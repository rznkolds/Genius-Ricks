package com.rznkolds.geniusricks.di

import com.rznkolds.geniusricks.data.repository.RickRepository
import com.rznkolds.geniusricks.data.repository.RickRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<RickRepository> {

        RickRepositoryImpl(get())
    }
}