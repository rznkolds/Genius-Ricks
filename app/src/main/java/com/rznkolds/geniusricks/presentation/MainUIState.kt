package com.rznkolds.geniusricks.presentation

import com.rznkolds.geniusricks.data.dto.Character

data class MainUIState(
    val characters: List<Character>? = null,
    val loading: String? = null,
    val error: String? = null,
)
