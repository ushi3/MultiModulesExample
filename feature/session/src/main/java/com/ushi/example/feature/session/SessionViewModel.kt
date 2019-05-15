package com.ushi.example.feature.session

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ushi.example.core.android.repository.Repositories
import com.ushi.example.model.Session
import com.ushi.example.model.Speaker
import io.reactivex.Maybe
import io.reactivex.Single

class SessionViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = Repositories.find(app).session()

    private lateinit var id: Number

    fun init(id: Int) {
        this.id = id
    }

    fun load(): Single<Session.Detail> {
        return repo.get(id.toInt())
    }

    fun getSpeaker(): Maybe<Speaker> {
        // TODO dummy
        return Maybe.fromSingle(load())
            .map { it.speaker }
            .onErrorComplete()
    }
}
