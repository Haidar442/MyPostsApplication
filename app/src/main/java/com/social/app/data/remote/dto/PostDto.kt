package com.social.app.data.remote.dto

import com.social.app.data.model.Post


data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)

fun PostDto.toPost(): Post {
    return Post(
        id = id,
        userId = userId,
        title = title,
        body = body,
    )
}