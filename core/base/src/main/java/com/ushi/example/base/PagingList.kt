package com.ushi.example.base


class PagingList<E> constructor(
    val metadata: Metadata,
    val list: List<E>
) {

    fun hasNext() = metadata.next != null

    data class Metadata(
        val page: Int,
        val next: Int?,
        val perPage: Int,
        val total: Int
    )
}
