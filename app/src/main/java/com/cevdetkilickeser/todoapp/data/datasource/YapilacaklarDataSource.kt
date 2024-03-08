package com.cevdetkilickeser.todoapp.data.datasource

import com.cevdetkilickeser.todoapp.data.entity.Yapilacaklar
import com.cevdetkilickeser.todoapp.room.YapilacaklarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacaklarDataSource(var ydao: YapilacaklarDao) {

    suspend fun kaydet(yapilacak_ad: String) {
        val yeniYapilacak = Yapilacaklar(0,yapilacak_ad)
        ydao.kaydet(yeniYapilacak)
    }

    suspend fun guncelle(yapilacak_id: Int, yapilacak_ad: String) {
        val guncellenenKisi = Yapilacaklar(yapilacak_id,yapilacak_ad)
        ydao.guncelle(guncellenenKisi)
    }

    suspend fun sil(yapilcak_id: Int) {
        val silinenYapilacak = Yapilacaklar(yapilcak_id,"")
        ydao.sil(silinenYapilacak)
    }

    suspend fun yapilacaklariYukle(): List<Yapilacaklar> =
        withContext(Dispatchers.IO) {
            return@withContext ydao.yapilacaklariYukle()
        }

    suspend fun ara(aramaKelimesi: String): List<Yapilacaklar> =
        withContext(Dispatchers.IO) {
            return@withContext ydao.ara(aramaKelimesi)
        }
}