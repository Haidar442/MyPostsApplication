package com.social.app.domain.usecase

import com.social.app.data.model.Post
import com.social.app.data.remote.PostApiService
import com.social.app.data.remote.dto.toPost
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val apiService: PostApiService
) {
    suspend operator fun invoke(): List<Post> = apiService.getPosts().map { it.toPost() }
}
