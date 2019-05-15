package com.ushi.example.feature.speaker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ushi.example.core.android.repository.Repositories
import com.ushi.example.model.Speaker
import io.reactivex.Maybe

class SpeakerViewModel(app: Application) : AndroidViewModel(app) {

    private val speakerRepo = Repositories.find(app).speaker()

    private lateinit var id: Number

    fun init(id: Int) {
        this.id = id
    }

    fun load() = speakerRepo.get(id.toInt())

    fun get() : Maybe<Speaker.Detail> {
        // TODO dummy
        return Maybe.fromSingle(load()).onErrorComplete()
    }
}
