package com.cevdetkilickeser.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cevdetkilickeser.todoapp.R
import com.cevdetkilickeser.todoapp.databinding.FragmentDetayBinding
import com.cevdetkilickeser.todoapp.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {

    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        val bundle: DetayFragmentArgs by navArgs()
        val gelenYapilacak = bundle.yapilacak

        binding.editTextAd.setText(gelenYapilacak.yapilacak_ad)

        binding.buttonGuncelle.setOnClickListener {
            val yapilacak_ad = binding.editTextAd.text.toString()
            guncelle(gelenYapilacak.yapilacak_id, yapilacak_ad)
        }

        return binding.root
    }

    fun guncelle(yapilacak_id:Int, yapilacak_ad:String){
        viewModel.guncelle(yapilacak_id,yapilacak_ad)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }
}