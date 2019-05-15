package com.ushi.example.repository.impl

import com.ushi.example.base.PagingList
import com.ushi.example.model.Session
import com.ushi.example.repository.SessionRepository
import io.reactivex.Single

class SessionRepositoryImpl : SessionRepository {

    override fun list(page: Int, limit: Int): Single<PagingList<Session>> {
        return Single.just(Data.sessions.map { Session(it.id, it.title) })
            .map {
                PagingList(
                    PagingList.Metadata(
                        page,
                        null,
                        limit,
                        2
                    ),
                    it
                )
            }
    }

    override fun get(id: Int): Single<Session.Detail> {
        return Single.just(Data.sessions.singleOrNull { it.id == id })
    }
}
