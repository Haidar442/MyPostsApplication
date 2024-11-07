package com.social.app.data.remote

import com.social.app.data.remote.dto.PostDto
import retrofit2.http.GET


interface PostApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}