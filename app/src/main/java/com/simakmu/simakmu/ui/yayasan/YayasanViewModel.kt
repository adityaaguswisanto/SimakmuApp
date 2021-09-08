package com.simakmu.simakmu.ui.yayasan

import androidx.lifecycle.ViewModel
import com.simakmu.simakmu.data.db.AppDatabase
import com.simakmu.simakmu.data.db.entities.Cabang
import com.simakmu.simakmu.data.db.entities.Lembaga
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YayasanViewModel @Inject constructor(
    private val db: AppDatabase
) : ViewModel() {

    suspend fun upsertCabang(cabang: Cabang) = db.yayasanDao().upsertCabang(
        cabang
    )

    suspend fun upsertLembaga(lembaga: Lembaga) = db.yayasanDao().upsertLembaga(
        lembaga
    )

    fun loadCabang() = db.yayasanDao().loadCabang()

    fun loadLembaga() = db.yayasanDao().loadLembaga()

}