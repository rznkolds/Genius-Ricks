package com.rznkolds.geniusricks.domain.usecase

import com.rznkolds.geniusricks.common.Resource
import com.rznkolds.geniusricks.data.dto.Character
import com.rznkolds.geniusricks.data.repository.RickRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException

class GetCharactersUseCaseImpl(
    private val repository: RickRepository
) : GetCharactersUseCase {

    override operator fun invoke(): Flow<Resource<List<Character>>> = flow {

        try {
            emit(Resource.Loading)

            emit(Resource.Success(repository.getCharacters()))

        } catch (e: IOException) {

            emit(Resource.Error("Couldn't reach server."))
        }

    }.flowOn(Dispatchers.IO)
}