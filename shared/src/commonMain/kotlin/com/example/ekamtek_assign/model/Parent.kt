package com.example.ekamtek_assign.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Parent(
    val sha: String,
    val url: String,
    @SerialName("html_url") val htmlUrl: String
)
