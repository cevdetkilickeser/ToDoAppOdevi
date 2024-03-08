package com.cevdetkilickeser.todoapp.di

import android.content.Context
import androidx.room.Room
import com.cevdetkilickeser.todoapp.data.datasource.YapilacaklarDataSource
import com.cevdetkilickeser.todoapp.data.repo.YapilacaklarRepository
import com.cevdetkilickeser.todoapp.room.Veritabani
import com.cevdetkilickeser.todoapp.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesYapilacaklarRepository(yds:YapilacaklarDataSource) : YapilacaklarRepository {
        return YapilacaklarRepository(yds)
    }

    @Provides
    @Singleton
    fun provideYapilacaklarDataSource(ydao:YapilacaklarDao) : YapilacaklarDataSource  {
        return YapilacaklarDataSource(ydao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : YapilacaklarDao {
        val vt = Room.databaseBuilder(context, Veritabani::class.java,"todo.sqlite")
            .createFromAsset("todo.sqlite").build()
        return vt.getyapilacaklarDao()
    }
}