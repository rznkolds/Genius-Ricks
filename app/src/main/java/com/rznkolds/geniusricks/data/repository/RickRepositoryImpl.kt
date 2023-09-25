package com.rznkolds.geniusricks.data.repository

import com.apollographql.apollo3.ApolloClient
import com.rznkolds.RickCharacterQuery
import com.rznkolds.geniusricks.data.dto.Character
import com.rznkolds.geniusricks.data.dto.mapToCharacter

class RickRepositoryImpl(
    private val api:ApolloClient
) : RickRepository {

    override suspend fun getCharacters(): List<Character>? {

        return api.query(RickCharacterQuery(1))
            .execute()
            .data
            ?.characters
            ?.results
            ?.map {
                it!!.mapToCharacter()
            }
    }
}