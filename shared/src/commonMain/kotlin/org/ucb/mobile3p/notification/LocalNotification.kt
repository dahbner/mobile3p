package org.ucb.mobile3p.notification

expect class LocalNotification(context: Any?) {
    fun show(title: String, message: String)
}
