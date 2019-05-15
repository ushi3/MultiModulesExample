package com.ushi.example.modules

import android.se.omapi.Session
import com.ushi.example.repository.RepositoryFactory
import com.ushi.example.repository.SessionRepository
import com.ushi.example.repository.SpeakerRepository
import com.ushi.example.repository.impl.SessionRepositoryImpl
import com.ushi.example.repository.impl.SpeakerRepositoryImpl

class AppRepositoryFactory : RepositoryFactory {

    override fun speaker(): SpeakerRepository = SpeakerRepositoryImpl()

    override fun session(): SessionRepository = SessionRepositoryImpl()
}
