package com.ramadan.task.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramadan.task.databinding.FragmentCharactersListBinding
import com.ramadan.task.ui.adapters.CharactersAdapter
import com.ramadan.task.ui.viewmodel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class CharactersListFragment : Fragment() {
    private val charactersViewModel : CharactersViewModel by viewModels()
    @Inject lateinit var charactersAdapter: CharactersAdapter
    private var _binding: FragmentCharactersListBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharactersListBinding.inflate(inflater , container , false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            charactersViewModel.charactersFlow.collectLatest {
                charactersAdapter.submitData(it)
            }
        }
    }

    private fun setupAdapter(){
      binding?.rvCharacters?.apply {
          layoutManager = LinearLayoutManager(activity)
          adapter = charactersAdapter
      }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}