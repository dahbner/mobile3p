# mobile3p

Proyecto en Kotlin Multiplatform (Android + iOS) con Compose Multiplatform, Koin, Room y Firebase (GitLive).

## Integrantes

- Ricardo Andrade : E25-5, rama `E25-5-Andres`
- Dabner Orozco: E25-6, rama `Feature/fcm-foreground`
- Christian Ferrufino: E50-2, rama `Feature/RealtimeDatabase`
- Gabriel Troncoso: E50-2, rama `Feature/RealtimeDatabase`

## Combinación elegida

E25-5 + E25-6 + E50-2 = 100 puntos

- E25-5: notificaciones internas básicas con NotificationManager (25)
- E25-6: FCM, recepción de push externa en foreground (25)
- E50-2: Firestore + Realtime Database, lista colaborativa con contador (50)

Cada uno trabajó en su propia rama, creada desde `main`, para no tener conflictos.

## Instrucciones

Se necesita Android Studio con el SDK de Android API 36 y 37, y JDK 17 o superior (sirve el que trae Android Studio). Para ver el diálogo del permiso de notificaciones hay que usar un emulador o celular con Android 13 o superior.

Primero hay que publicar el Design System (`edu.ucb.ds:shared:1.0.0-SNAPSHOT`), ejecutando esto en su repositorio:

```bash
./gradlew publishToMavenLocal
```

El `google-services.json` ya está en `androidApp/`. En la consola de Firebase hay que tener Firestore y Realtime Database creados en modo de prueba. La colección `tareas` y el nodo `/stats/completadas` se crean solos al usar la app.

Para ejecutar, abrir el proyecto en Android Studio, cambiarse a la rama del ejercicio (`git checkout <rama>`) y darle Run a `androidApp`, o compilar con:

```bash
./gradlew :androidApp:assembleDebug
```

La primera vez que se abre la app hay que aceptar el permiso de notificaciones.

### Cómo probar cada ejercicio

**E25-5** (rama `E25-5-Andres`): `App.kt` muestra `LocalNotificationScreen()`. Al pulsar "Enviar notificación" aparece "Hola desde la app" con un icono de campana. Si sales de la app y tocas la notificación, la app se vuelve a abrir.

**E25-6** (rama `Feature/fcm-foreground`): en pantalla se ven el token FCM y el `message_id`. Con la app abierta, se envía un mensaje desde Firebase (Messaging → Nueva campaña → Notificaciones → Enviar mensaje de prueba) usando ese token. En "Datos personalizados" se puede agregar `message_id`. Aparece la notificación y, al tocarla, la pantalla muestra el `message_id`.

**E50-2** (rama `Feature/RealtimeDatabase`): `App.kt` muestra `TasksScreen()`. Las tareas que se agregan se guardan en Firestore (`tareas`). Al marcar o desmarcar una tarea, el contador de completadas (`/stats/completadas` en RTDB) sube o baja con animación. Si se abre en dos dispositivos, los dos se actualizan en tiempo real.

## Decisiones técnicas

En general, cada ejercicio tiene su propia rama y repartimos los archivos para no editar las mismas líneas al juntar en `main`. Reutilizamos lo que ya traía la base: el canal de notificaciones `"general"` (en `MainApplication`), el permiso `POST_NOTIFICATIONS` (en `MainActivity`) y la configuración de FCM. También seguimos la misma arquitectura por capas (data / domain / presentation) con Koin.

### E25-5

- El canal es el `"general"` que la base ya crea en `MainApplication` (Android 8+).
- `MainActivity` pide el permiso `POST_NOTIFICATIONS` en Android 13+.
- La pantalla `LocalNotificationScreen` tiene un botón que llama a `LocalNotification.show(...)`.
- Para el PendingIntent se usa `getLaunchIntentForPackage`, porque `LocalNotification` está en el módulo `shared` y no puede referenciar a `MainActivity`. Lleva `FLAG_IMMUTABLE`, que es obligatorio desde Android 12.
- La notificación usa un icono vectorial propio (`ic_notification.xml`) y título y texto propios.
- Para obtener el `Context` desde código compartido se hizo `rememberLocalNotification()` con `expect/actual`. En Android usa `LocalContext.current`, así no hubo que tocar Koin.

### E25-6

- `PushMessagingService` recibe el mensaje en `onMessageReceived`. Ese método solo se ejecuta con la app en primer plano; en segundo plano la notificación la muestra Firebase.
- Se arma una notificación local con un PendingIntent hacia `MainActivity` que lleva el extra `message_id`. Se toma de `data["message_id"]` y, si no viene, se usa el `messageId` del mensaje.
- `MainActivity` lee el extra y se lo pasa a `App(messageId)` para mostrarlo junto al token FCM.

### E50-2

- Las tareas están en la colección `tareas` de Firestore (`title`, `completed`) y el contador está en RTDB en `/stats/completadas`.
- La lista se escucha con `snapshots` de Firestore (equivale a `addSnapshotListener`) y el contador con `valueEvents` de RTDB (equivale a `ValueEventListener`), los dos como `Flow`.
- Al marcar o desmarcar, primero se actualiza Firestore y después el contador con una transacción de RTDB (`runTransaction`, que suma o resta 1 y nunca baja de 0).
- Si falla Firestore, no se toca RTDB. Si falla RTDB, se hace un rollback lógico que devuelve la tarea a como estaba en Firestore. Los errores se registran con logs y se muestran en la UI.
- La UI tiene la lista con checkboxes, un campo para agregar tareas y el contador animado con `animateIntAsState`. Mientras una tarea se está guardando queda bloqueada, para evitar el doble clic.