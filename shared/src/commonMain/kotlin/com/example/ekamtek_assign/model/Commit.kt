package com.example.ekamtek_assign.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Commit(
    val author: CommitAuthor,
    val committer: CommitCommitter,
    val message: String,
    val tree: Tree,
    @SerialName("url") val commitUrl: String,
    @SerialName("comment_count") val commentCount: Int,
    val verification: Verification
)
