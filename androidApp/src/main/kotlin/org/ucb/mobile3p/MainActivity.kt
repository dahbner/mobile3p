package org.ucb.mobile3p

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.ucb.mobile3p.notification.LocalNotification

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // Android 13+ exige pedir el permiso de notificaciones en tiempo de ejecución
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
                // Prueba de notificación interna
                if (granted) LocalNotification(this).show("mobile3p", "Notificaciones activadas")
            }.launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        val messageId = intent.getStringExtra("message_id")

        setContent {
            App(messageId)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}