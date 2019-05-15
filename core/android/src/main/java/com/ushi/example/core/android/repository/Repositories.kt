package com.ushi.example.core.android.repository

import android.app.Application
import android.content.Context
import com.ushi.example.repository.RepositoryFactory
import com.ushi.example.repository.RepositoryOwner
import java.lang.IllegalStateException

object Repositories {

    fun find(context: Context): RepositoryFactory {
        val owner = when (context) {
            is Application -> context
            else -> context.applicationContext
        } as? RepositoryOwner

        return owner?.getRepositoryFactory()
            ?: throw IllegalStateException("Application must be implements 'RepositoryFactory'")
    }
}
