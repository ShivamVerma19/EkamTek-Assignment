package com.example.ekamtek_assign.Api

import com.example.ekamtek_assign.model.CommitResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

open class GithubApi {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

    // Fetch commits
    open suspend fun getCommits(): List<CommitResponse> {
        return client.get("https://api.github.com/repos/flutter/flutter/commits")
            .body()
    }
}