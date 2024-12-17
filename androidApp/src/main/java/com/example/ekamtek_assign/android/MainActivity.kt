package com.example.ekamtek_assign.android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ekamtek_assign.Api.GithubApi
import androidx.compose.ui.graphics.Color
import com.example.ekamtek_assign.model.CommitResponse
import androidx.compose.foundation.lazy.items
import com.example.ekamtek_assign.model.Commit
import com.example.ekamtek_assign.model.CommitAuthor
import com.example.ekamtek_assign.model.CommitCommitter
import com.example.ekamtek_assign.model.Parent
import com.example.ekamtek_assign.model.Tree
import com.example.ekamtek_assign.model.User
import com.example.ekamtek_assign.model.Verification

class MainActivity : ComponentActivity() {
    private val api = GithubApi()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CommitListScreen(api)
                }
            }
        }
    }
}



@Composable
fun CommitListScreen(api: GithubApi) {

    val commits = remember { mutableStateOf<List<CommitResponse>>(emptyList()) }


    LaunchedEffect(Unit) {
        commits.value = api.getCommits()
    }


    LazyColumn {
        items(commits.value) { commit ->
            CommitItem(
                authorName = commit.commit.author.name,
                sha = commit.sha
            )
        }
    }
}

@Composable
fun CommitItem(authorName: String, sha: String) {
    // if the commit hash ends in a number
    val backgroundColor = if (sha.last().isDigit()) Color.Yellow else Color.Transparent

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Text(text = "author_name : $authorName\nsha : $sha")
    }
}


@Preview
@Composable
fun PreviewCommitListScreen() {
    MyApplicationTheme {
        CommitListScreen(
            api = object : GithubApi() {
                override suspend fun getCommits(): List<CommitResponse> {
                    return listOf(
                        CommitResponse(
                            sha = "a12345e",
                            nodeId = "node123",
                            commit = Commit(
                                author = CommitAuthor("John Doe", "johndoe@example.com", "2024-06-12T12:00:00Z"),
                                committer = CommitCommitter("John Doe", "johndoe@example.com", "2024-06-12T12:00:00Z"),
                                message = "Initial commit",
                                tree = Tree("tree123", "https://example.com/tree"),
                                commitUrl = "https://example.com/commit/a12345e",
                                commentCount = 0,
                                verification = Verification(true, "valid", null, null)
                            ),
                            url = "https://example.com/commit/a12345e",
                            htmlUrl = "https://example.com/commit/a12345e",
                            commentsUrl = "https://example.com/comments",
                            author = User(
                                login = "johndoe",
                                id = 1,
                                nodeId = "usernode123",
                                avatarUrl = "https://example.com/avatar.jpg",
                                gravatarId = "",
                                url = "https://example.com/user",
                                htmlUrl = "https://example.com/user/johndoe",
                                followersUrl = "https://example.com/followers",
                                followingUrl = "https://example.com/following",
                                gistsUrl = "https://example.com/gists",
                                starredUrl = "https://example.com/starred",
                                subscriptionsUrl = "https://example.com/subscriptions",
                                organizationsUrl = "https://example.com/orgs",
                                reposUrl = "https://example.com/repos",
                                eventsUrl = "https://example.com/events",
                                receivedEventsUrl = "https://example.com/received_events",
                                type = "User",
                                userViewType = "Full",
                                siteAdmin = false
                            ),
                            committer = User(
                                login = "johndoe",
                                id = 1,
                                nodeId = "usernode123",
                                avatarUrl = "https://example.com/avatar.jpg",
                                gravatarId = "",
                                url = "https://example.com/user",
                                htmlUrl = "https://example.com/user/johndoe",
                                followersUrl = "https://example.com/followers",
                                followingUrl = "https://example.com/following",
                                gistsUrl = "https://example.com/gists",
                                starredUrl = "https://example.com/starred",
                                subscriptionsUrl = "https://example.com/subscriptions",
                                organizationsUrl = "https://example.com/orgs",
                                reposUrl = "https://example.com/repos",
                                eventsUrl = "https://example.com/events",
                                receivedEventsUrl = "https://example.com/received_events",
                                type = "User",
                                userViewType = "Full",
                                siteAdmin = false
                            ),
                            parents = listOf(
                                Parent(
                                    sha = "parent123",
                                    url = "https://example.com/parent",
                                    htmlUrl = "https://example.com/parent"
                                )
                            )
                        ),

                        CommitResponse(
                            sha = "b654321",
                            nodeId = "node456",
                            commit = Commit(
                                author = CommitAuthor("Jane Smith", "janesmith@example.com", "2024-06-13T14:00:00Z"),
                                committer = CommitCommitter("Jane Smith", "janesmith@example.com", "2024-06-13T14:00:00Z"),
                                message = "Update README",
                                tree = Tree("tree456", "https://example.com/tree"),
                                commitUrl = "https://example.com/commit/b654321",
                                commentCount = 2,
                                verification = Verification(true, "valid", null, null)
                            ),
                            url = "https://example.com/commit/b654321",
                            htmlUrl = "https://example.com/commit/b654321",
                            commentsUrl = "https://example.com/comments",
                            author = User(
                                login = "janesmith",
                                id = 2,
                                nodeId = "usernode456",
                                avatarUrl = "https://example.com/avatar2.jpg",
                                gravatarId = "",
                                url = "https://example.com/user",
                                htmlUrl = "https://example.com/user/janesmith",
                                followersUrl = "https://example.com/followers",
                                followingUrl = "https://example.com/following",
                                gistsUrl = "https://example.com/gists",
                                starredUrl = "https://example.com/starred",
                                subscriptionsUrl = "https://example.com/subscriptions",
                                organizationsUrl = "https://example.com/orgs",
                                reposUrl = "https://example.com/repos",
                                eventsUrl = "https://example.com/events",
                                receivedEventsUrl = "https://example.com/received_events",
                                type = "User",
                                userViewType = "Full",
                                siteAdmin = false
                            ),
                            committer = User(
                                login = "janesmith",
                                id = 2,
                                nodeId = "usernode456",
                                avatarUrl = "https://example.com/avatar2.jpg",
                                gravatarId = "",
                                url = "https://example.com/user",
                                htmlUrl = "https://example.com/user/janesmith",
                                followersUrl = "https://example.com/followers",
                                followingUrl = "https://example.com/following",
                                gistsUrl = "https://example.com/gists",
                                starredUrl = "https://example.com/starred",
                                subscriptionsUrl = "https://example.com/subscriptions",
                                organizationsUrl = "https://example.com/orgs",
                                reposUrl = "https://example.com/repos",
                                eventsUrl = "https://example.com/events",
                                receivedEventsUrl = "https://example.com/received_events",
                                type = "User",
                                userViewType = "Full",
                                siteAdmin = false
                            ),
                            parents = listOf(
                                Parent(
                                    sha = "parent456",
                                    url = "https://example.com/parent2",
                                    htmlUrl = "https://example.com/parent2"
                                )
                            )
                        )
                    )
                }
            }
        )
    }
}
