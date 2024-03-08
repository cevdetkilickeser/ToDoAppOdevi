package com.cevdetkilickeser.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.cevdetkilickeser.todoapp.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitViewModel @Inject constructor(val yrepo : YapilacaklarRepository) : ViewModel() {

    fun kaydet(yapilacak_ad:String){
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.kaydet(yapilacak_ad)
        }
    }
}