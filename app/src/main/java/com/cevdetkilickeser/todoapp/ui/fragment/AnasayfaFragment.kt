package com.cevdetkilickeser.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.cevdetkilickeser.todoapp.R
import com.cevdetkilickeser.todoapp.databinding.FragmentAnasayfaBinding
import com.cevdetkilickeser.todoapp.ui.adapter.YapilacaklarAdapter
import com.cevdetkilickeser.todoapp.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner){
            val kisilerAdapter = YapilacaklarAdapter(requireContext(),it,viewModel)
            binding.yapilacaklarRv.adapter = kisilerAdapter
        }


        binding.yapilacaklarRv.layoutManager = LinearLayoutManager(requireContext())

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kayitGecis)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }
}