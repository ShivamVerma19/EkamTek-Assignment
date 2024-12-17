package com.example.ekamtek_assign.model

import kotlinx.serialization.Serializable

@Serializable
data class Tree(
    val sha: String,
    val url: String
)
