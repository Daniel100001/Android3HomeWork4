package com.example.rickandmorty.ui.fragments.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentFilterBinding

class FilterFragment : Fragment() {

    private lateinit var binding: FragmentFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.ready.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val status = binding.editTextStatus.text.toString()
            val species = binding.editTextSpecies.text.toString()
            val type = binding.editTextType.text.toString()
            val gender = binding.editTextGender.text.toString()

            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("status", status)
            bundle.putString("species", species)
            bundle.putString("type", type)
            bundle.putString("gender", gender)

            findNavController().navigate(
                R.id.action_filterFragment_to_characterFragment,
                bundle
            )
        }
    }
}