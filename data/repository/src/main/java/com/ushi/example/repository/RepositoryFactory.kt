package com.ushi.example.repository

interface RepositoryFactory {

    fun speaker(): SpeakerRepository

    fun session(): SessionRepository
}
