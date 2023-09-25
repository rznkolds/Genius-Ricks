package com.rznkolds.geniusricks.domain.usecase

import com.rznkolds.geniusricks.common.Resource
import com.rznkolds.geniusricks.data.dto.Character
import kotlinx.coroutines.flow.Flow

interface GetCharactersUseCase {

    operator fun invoke(): Flow<Resource<List<Character>>>
}