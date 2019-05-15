package com.ushi.example.repository

import com.ushi.example.base.PagingList
import com.ushi.example.model.Speaker
import io.reactivex.Single

interface SpeakerRepository {

    fun list(page: Int, limit: Int = 20): Single<PagingList<Speaker>>

    fun get(id: Int) : Single<Speaker.Detail>
}
