package com.example.ekamtek_assign.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommitResponse(
    val sha: String,
    @SerialName("node_id") val nodeId: String,
    val commit: Commit,
    val url: String,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("comments_url") val commentsUrl: String,
    val author: User,
    val committer: User,
    val parents: List<Parent>
)




