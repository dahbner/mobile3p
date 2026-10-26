package org.ucb.mobile3p.notification

import androidx.compose.runtime.Composable

// Crea un LocalNotification con el contexto de cada plataforma
@Composable
expect fun rememberLocalNotification(): LocalNotification
