package com.social.app.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.social.app.data.model.Post
import com.social.app.databinding.BottomSheetPostDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetPostDetailsBinding
    private lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            post = it.getParcelable("post")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetPostDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.postTitle.text = post.title
        binding.postBody.text = post.body
    }

    companion object {
        fun newInstance(post: Post) = PostDetailsBottomSheetFragment().apply {
            arguments = Bundle().apply {
                putParcelable("post", post)
            }
        }
    }
}
