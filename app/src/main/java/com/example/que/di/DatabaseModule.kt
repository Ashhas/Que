package com.example.que.di

import androidx.room.Room
import com.example.que.data.QuoteDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), QuoteDatabase::class.java, "quote_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<QuoteDatabase>().quoteDao()
    }
}