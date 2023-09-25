package com.rznkolds.geniusricks

import android.app.Application
import com.rznkolds.geniusricks.di.apolloModule
import com.rznkolds.geniusricks.di.repositoryModule
import com.rznkolds.geniusricks.di.useCaseModule
import com.rznkolds.geniusricks.di.viewModelModule
import com.rznkolds.geniusricks.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class GeniusRicks: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    apolloModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}