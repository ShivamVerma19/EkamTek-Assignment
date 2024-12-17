package com.example.ekamtek_assign

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform