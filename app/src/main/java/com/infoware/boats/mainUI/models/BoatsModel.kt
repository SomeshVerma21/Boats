package com.infoware.boats.mainUI.models

data class BoatsModel(
    val data: List<Data>,
    val messageCode: String,
    val statusCode: Int,
    val success: Boolean
)