package com.cevdetkilickeser.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cevdetkilickeser.todoapp.data.entity.Yapilacaklar
import com.cevdetkilickeser.todoapp.databinding.CardTasarimBinding
import com.cevdetkilickeser.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.cevdetkilickeser.todoapp.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(var mContext: Context, var yapilacaklarListesi: List<Yapilacaklar>, var viewModel: AnasayfaViewModel)

    : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacak = yapilacaklarListesi.get(position)
        val t = holder.tasarim
        t.textViewKisiAd.text = yapilacak.yapilacak_ad

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(yapilacak = yapilacak)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${yapilacak.yapilacak_ad} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.sil(yapilacak.yapilacak_id)
                }.show()
        }
    }
}