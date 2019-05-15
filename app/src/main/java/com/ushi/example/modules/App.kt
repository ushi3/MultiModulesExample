package com.ushi.example.modules

import android.app.Activity
import android.app.Application
import com.ushi.example.core.android.navigation.Navigator
import com.ushi.example.core.android.navigation.NavigatorFactory
import com.ushi.example.repository.RepositoryFactory
import com.ushi.example.repository.RepositoryOwner

class App : Application(), NavigatorFactory, RepositoryOwner {

    private val repo = AppRepositoryFactory()

    override fun onCreate() {
        super.onCreate()
    }

    override fun getNavigator(context: Activity): Navigator = AppNavigator(context)

    override fun getRepositoryFactory(): RepositoryFactory = repo
}
