package com.cevdetkilickeser.todoapp.data.repo

import com.cevdetkilickeser.todoapp.data.datasource.YapilacaklarDataSource
import com.cevdetkilickeser.todoapp.data.entity.Yapilacaklar

class YapilacaklarRepository(var yds:YapilacaklarDataSource) {

    suspend fun kaydet(yapilacak_ad:String) = yds.kaydet(yapilacak_ad)

    suspend fun guncelle(yapilacak_id:Int,yapilacak_ad:String) = yds.guncelle(yapilacak_id, yapilacak_ad)

    suspend fun sil(yapilacak_id:Int) = yds.sil(yapilacak_id)

    suspend fun yapilacakiYukle() : List<Yapilacaklar> = yds.yapilacaklariYukle()

    suspend fun ara(aramaKelimesi: String): List<Yapilacaklar> = yds.ara(aramaKelimesi)
}