package org.ucb.mobile3p.notification

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun rememberLocalNotification(): LocalNotification {
    val context = LocalContext.current
    return remember(context) { LocalNotification(context) }
}
