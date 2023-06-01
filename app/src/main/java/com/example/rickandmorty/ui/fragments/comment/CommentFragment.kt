package com.example.rickandmorty.ui.fragments.comment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.databinding.FragmentCommentBinding
import com.example.rickandmorty.models.CommentDeleteModel
import com.example.rickandmorty.models.CommentModel
import com.example.rickandmorty.models.CommentPutModel
import com.example.rickandmorty.ui.fragments.character.CharacterViewModel

class CommentFragment : Fragment( ){

    private var _binding: FragmentCommentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CommentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRequests()
    }

    private fun setUpRequests() {
        binding.buttonPost.setOnClickListener {
            val commentBody = binding.editText.text.toString().trim()
            val comment = CommentModel(101, 51, "Radin", "Dodic@gmail.com", commentBody)
            viewModel.addComment(comment = comment)
            Log.e("comment Post = ", comment.toString())
        }

        binding.buttonPut.setOnClickListener {
            val commentBody = binding.editText.text.toString().trim()
            val comment = CommentPutModel(1, title = "fds", body = commentBody, 1)
            viewModel.changeComment(comment = comment)
            Log.e("comment Put = ", comment.toString())
        }

        binding.buttonDelete.setOnClickListener {
            val comment = CommentDeleteModel(
                1,
                1,
                "id labore ex et quam laborum",
                "Eliseo@gardner.biz",
                "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
            )
            viewModel.deleteComment(comment = comment)
            Log.e("Delete", comment.toString())
        }
    }
}