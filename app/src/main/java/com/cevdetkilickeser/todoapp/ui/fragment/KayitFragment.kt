package com.cevdetkilickeser.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cevdetkilickeser.todoapp.R
import com.cevdetkilickeser.todoapp.databinding.FragmentKayitBinding
import com.cevdetkilickeser.todoapp.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {

    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KayitViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val yapilacak_ad = binding.editTextAd.text.toString()
            kaydet(yapilacak_ad)
        }

        return binding.root
    }

    fun kaydet(yapilacak_ad:String){
        viewModel.kaydet(yapilacak_ad)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:KayitViewModel by viewModels()
        viewModel = tempViewModel
    }
}