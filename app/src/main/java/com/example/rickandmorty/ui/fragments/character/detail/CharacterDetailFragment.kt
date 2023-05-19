package com.example.rickandmorty.ui.fragments.character.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmorty.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : Fragment() {

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CharacterViewModel>()
    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserves()
    }

    private fun setUpObserves() {
        viewModel.fetchSingleCharacter(args.myModel.id).observe(viewLifecycleOwner) {
            binding.name.text = args.myModel.name
            Glide.with(binding.imageView).load(args.myModel.image)
                .into(binding.imageView)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}