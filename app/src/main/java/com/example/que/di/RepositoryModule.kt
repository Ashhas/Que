package com.example.que.di

import com.example.que.repository.QuoteRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    single { QuoteRepositoryImpl(get()) }
}