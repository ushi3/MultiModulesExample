package com.ushi.example.core.android.navigation

import android.app.Activity
import android.content.Context
import java.lang.IllegalArgumentException

object Navigators {

    private fun find(obj: Any) : NavigatorFactory? {
        return obj as? NavigatorFactory
    }

    fun find(context: Activity): Navigator {
        val factory = find(context as Any)
            ?: find(context.applicationContext as Any)
            ?: throw IllegalArgumentException("$context or ${context.applicationContext} is no implementation NavigatorOwner")

        return factory.getNavigator(context)
    }
}
