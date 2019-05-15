package com.ushi.example.model

data class Speaker(
    val id: Int,
    val name: String,
    val imageRes: Int
) {

    data class Detail(
        val id: Int,
        val name: String,
        val imageRes: Int,
        val sns: String,
        val sessions: List<Session>
    )
}
