package com.ushi.example.core.android.navigation

import android.app.Activity
import androidx.fragment.app.Fragment
import java.lang.IllegalArgumentException

object Navigators {

    private fun asFactoryOrNull(obj: Any?): NavigatorFactory? {
        return obj as? NavigatorFactory
    }

    private fun asInterceptorOrNull(obj: Any?): NavigatorInterceptor? {
        return obj as? NavigatorInterceptor
    }

    /**
     * for Activity
     * - NavigatorFactory is cast from Application
     * - NavigatorInterceptor is cast from Activity
     *
     * App          <- Factory
     *  + Activity  <- Interceptor
     *
     * obtain navigation chain : Interceptor -> Factory
     */
    fun find(activity: Activity): Navigator {
        val factory = (asFactoryOrNull(activity.applicationContext)
            ?: throw IllegalArgumentException("${activity.applicationContext} must be implementation NavigatorFactory"))

        return obtainNavigator(
            factory.getNavigator(activity),
            asInterceptorOrNull(activity)
        )
    }

    /**
     * for Fragment
     * - NavigationFactory is cast from Application
     * NavigatorInterceptor is cast from Activity, parent Fragment, Fragment
     *
     * App               <- Factory
     *  + Activity       <- Interceptor 1
     *    + Fragment     <- Interceptor 2
     *      + Fragment   <- Interceptor 3
     *        + Fragment <- Interceptor 4
     *
     * obtain navigation chain : Interceptor 4 -> Interceptor 3 -> Interceptor 2 -> Interceptor 1 -> Factory
     */
    fun find(fragment: Fragment): Navigator {
        return when (val parent = fragment.parentFragment) {
            null -> obtainNavigator(
                find(fragment.requireActivity()),
                asInterceptorOrNull(fragment)
            )

            else -> obtainNavigator(
                find(parent),
                asInterceptorOrNull(fragment)
            )
        }
    }

    private fun obtainNavigator(
        navigator: Navigator,
        interceptor: NavigatorInterceptor?
    ): Navigator {
        return when (interceptor) {
            null -> navigator
            else -> NavigatorChain(navigator, interceptor.getNavigatorOverlay())
        }
    }
}
