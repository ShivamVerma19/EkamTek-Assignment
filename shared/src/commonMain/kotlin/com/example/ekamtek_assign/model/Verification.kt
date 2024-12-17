package com.example.ekamtek_assign.model

import kotlinx.serialization.Serializable

@Serializable
data class Verification(
    val verified: Boolean,
    val reason: String,
    val signature: String?,
    val payload: String?
)
