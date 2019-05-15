package com.ushi.example.model

data class Session(
    val id: Int,
    val title: String
) {

    data class Detail(
        val id: Int,
        val title: String,
        val description: String,
        val speaker: Speaker
    )
}
