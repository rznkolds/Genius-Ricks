package com.rznkolds.geniusricks.di

import com.apollographql.apollo3.ApolloClient
import org.koin.dsl.module

val apolloModule = module {

    single {

        ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .build()
    }
}