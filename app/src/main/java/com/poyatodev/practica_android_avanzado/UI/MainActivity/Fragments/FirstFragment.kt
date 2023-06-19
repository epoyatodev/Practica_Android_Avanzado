package com.poyatodev.practica_android_avanzado.UI.MainActivity.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.poyatodev.practica_android_avanzado.UI.MainActivity.Adapters.RecyclerViewListAdapter
import com.poyatodev.practica_android_avanzado.UI.MainActivity.Model.Heroe
import com.poyatodev.practica_android_avanzado.databinding.FragmentFirstBinding
import com.poyatodev.practica_android_avanzado.UI.MainActivity.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private  val viewModel: MainActivityViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RecyclerViewListAdapter(){ heroeId:String ->
            findNavController().navigate(
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(heroeId)
            )
        }
        binding.rvHeroesList.layoutManager = LinearLayoutManager(binding.rvHeroesList.context)
        binding.rvHeroesList.adapter = adapter

        viewModel.heroes.observe(viewLifecycleOwner){
            Log.d("Fragment1 heroe list size", "${it.size}")
            adapter.submitList(it)
        }
        viewModel.getHeroes()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}