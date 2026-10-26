package org.ucb.mobile3p

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform