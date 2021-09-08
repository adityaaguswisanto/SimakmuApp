package com.simakmu.simakmu.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.simakmu.simakmu.data.db.entities.CURRENT_CABANG_ID
import com.simakmu.simakmu.data.db.entities.CURRENT_LEMBAGA_ID
import com.simakmu.simakmu.data.db.entities.Cabang
import com.simakmu.simakmu.data.db.entities.Lembaga

@Dao
interface YayasanDao {

    //cabang
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCabang(cabang: Cabang): Long

    @Query("SELECT * FROM cabang WHERE uid = $CURRENT_CABANG_ID")
    fun loadCabang(): LiveData<Cabang>

    //lembaga
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertLembaga(lembaga: Lembaga): Long

    @Query("SELECT * FROM lembaga WHERE uid = $CURRENT_LEMBAGA_ID")
    fun loadLembaga(): LiveData<Lembaga>

}