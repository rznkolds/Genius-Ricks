package com.rznkolds.geniusricks.di

import com.rznkolds.geniusricks.domain.usecase.GetCharactersUseCase
import com.rznkolds.geniusricks.domain.usecase.GetCharactersUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    factory<GetCharactersUseCase> {

        GetCharactersUseCaseImpl(get())
    }
}