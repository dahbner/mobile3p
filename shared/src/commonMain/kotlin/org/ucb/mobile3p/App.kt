package org.ucb.mobile3p

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ucb.mobile3p.localnotification.presentation.screen.LocalNotificationScreen
import org.ucb.mobile3p.notifications.presentation.screen.NotificationsScreen
import org.ucb.mobile3p.tasks.presentation.screen.TasksScreen

@Composable
@Preview
fun App(messageId: String? = null) {
    MaterialTheme {
        // Pantalla que se muestra: "fcm" (E25-6), "local" (E25-5) o "tareas" (E50-2)
        var screen by remember { mutableStateOf("fcm") }

        Column(modifier = Modifier.safeContentPadding()) {
            // Botones para cambiar de ejercicio
            Row(modifier = Modifier.padding(16.dp)) {
                Button(onClick = { screen = "fcm" }) { Text("FCM") }
                Button(onClick = { screen = "local" }, modifier = Modifier.padding(start = 8.dp)) {
                    Text("Local")
                }
                Button(onClick = { screen = "tareas" }, modifier = Modifier.padding(start = 8.dp)) {
                    Text("Tareas")
                }
            }

            when (screen) {
                "fcm" -> {
                    // E25-6: message_id del deep link + token FCM
                    Text(
                        text = "message_id: ${messageId ?: "(app abierta normal)"}",
                        modifier = Modifier.padding(16.dp)
                    )
                    NotificationsScreen()
                }
                // E25-5: botón que dispara la notificación local
                "local" -> LocalNotificationScreen()
                // E50-2: lista de tareas (Firestore) + contador (Realtime Database)
                else -> TasksScreen()
            }
        }
    }
}
