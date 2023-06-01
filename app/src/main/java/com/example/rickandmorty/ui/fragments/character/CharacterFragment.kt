package com.example.rickandmorty.ui.fragments.character

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.models.CharacterModel
import com.example.rickandmorty.ui.adapters.CharacterAdapter

class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!
    private val characterAdapter = CharacterAdapter(this::onItemClick)
    private val viewModel by viewModels<CharacterViewModel>()

    private fun onItemClick(args: CharacterModel) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(
                args
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpRequests()
        setUpObserves()
        setUpListeners()
    }

    private fun initialize() {
        binding.characterRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    private fun setUpRequests() {
        val bundle = arguments
        if (bundle != null) {
            val name = bundle.getString("name")
            val status = bundle.getString("status")
            val species = bundle.getString("species")
            val type = bundle.getString("type")
            val gender = bundle.getString("gender")
            viewModel.fetchCharacters(name!!,status!!,species!!,type!!,gender!!)
        } else {
            Log.e("args", "Bundle is null")
        }
    }

    private fun setUpObserves() {
        viewModel.characterLiveData.observe(viewLifecycleOwner) {
            characterAdapter.submitList(it.results)
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUpListeners() {
        binding.buttonMore.setOnClickListener{
            findNavController().navigate(R.id.filterFragment)
        }
    }
}