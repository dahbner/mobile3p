package org.ucb.mobile3p.localnotification.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.ucb.mobile3p.notification.rememberLocalNotification

@Composable
fun LocalNotificationScreen() {
    val localNotification = rememberLocalNotification()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Notificaciones locales")
        Button(onClick = {
            localNotification.show("Hola desde la app", "Esta es una notificación local con NotificationManager")
        }) {
            Text("Enviar notificación")
        }
    }
}
