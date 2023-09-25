package com.rznkolds.geniusricks.data.repository

import com.rznkolds.geniusricks.data.dto.Character

interface RickRepository {

    suspend fun getCharacters(): List<Character>?
}

