package com.rznkolds.geniusricks.data.dto

import com.rznkolds.RickCharacterQuery

data class Character(
    val id:String?,
    val name:String?,
    val image:String?
)

fun RickCharacterQuery.Result.mapToCharacter(): Character {

    return Character(
        id = id ?: "",
        name = name ?: "",
        image = image ?: ""
    )
}