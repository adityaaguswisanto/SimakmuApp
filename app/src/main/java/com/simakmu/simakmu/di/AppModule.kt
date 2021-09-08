package com.simakmu.simakmu.di

import android.content.Context
import androidx.room.Room
import com.simakmu.simakmu.data.db.AppDatabase
import com.simakmu.simakmu.data.db.dao.YayasanDao
import com.simakmu.simakmu.data.store.UserStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "simakmu.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideYayasanDao(appDatabase: AppDatabase): YayasanDao {
        return appDatabase.yayasanDao()
    }

    @Provides
    @Singleton
    fun provideUserStore(@ApplicationContext context: Context): UserStore {
        return UserStore(context)
    }

}