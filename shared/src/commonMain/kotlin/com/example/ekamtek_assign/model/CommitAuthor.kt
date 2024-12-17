package com.example.ekamtek_assign.model

import kotlinx.serialization.Serializable

@Serializable
data class CommitAuthor(
    val name: String,
    val email: String,
    val date: String
)
