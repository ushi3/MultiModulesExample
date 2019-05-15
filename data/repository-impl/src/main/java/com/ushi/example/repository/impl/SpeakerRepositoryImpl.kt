package com.ushi.example.repository.impl

import androidx.lifecycle.Transformations.map
import com.ushi.example.base.PagingList
import com.ushi.example.model.Speaker
import com.ushi.example.repository.SpeakerRepository
import io.reactivex.Single

class SpeakerRepositoryImpl : SpeakerRepository {

    override fun list(page: Int, limit: Int): Single<PagingList<Speaker>> {
        return Single.just(Data.speakers.map { Speaker(it.id, it.name, it.imageRes) })
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

    override fun get(id: Int): Single<Speaker.Detail> {
        return Single.just(Data.speakers.singleOrNull { it.id == id })
    }
}
