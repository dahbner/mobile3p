package org.ucb.mobile3p.notification

actual class LocalNotification actual constructor(
    context: Any?
) {
    actual fun show(title: String, message: String) {
        println("Notificación iOS pendiente: $title - $message")
    }
}
