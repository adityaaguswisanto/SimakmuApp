package com.simakmu.simakmu.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.simakmu.simakmu.data.db.dao.YayasanDao
import com.simakmu.simakmu.data.db.entities.Cabang
import com.simakmu.simakmu.data.db.entities.Lembaga

@Database(
    entities = [
        Cabang::class, Lembaga::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun yayasanDao(): YayasanDao

}