package org.ucb.mobile3p.scheduler

actual class LogScheduler actual constructor(
    context: Any?
) {
    actual fun schedulePeriodicalUpload() {
        // iOS: sin WorkManager
    }
}
