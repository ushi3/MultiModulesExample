package com.ushi.example.repository

import com.ushi.example.base.PagingList
import com.ushi.example.model.Session
import io.reactivex.Single

interface SessionRepository {

    fun list(page: Int, limit: Int = 20): Single<PagingList<Session>>

    fun get(id: Int): Single<Session.Detail>

}
