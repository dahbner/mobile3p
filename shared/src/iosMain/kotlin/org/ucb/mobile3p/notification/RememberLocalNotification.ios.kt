package org.ucb.mobile3p.notification

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
actual fun rememberLocalNotification(): LocalNotification = remember { LocalNotification(null) }
