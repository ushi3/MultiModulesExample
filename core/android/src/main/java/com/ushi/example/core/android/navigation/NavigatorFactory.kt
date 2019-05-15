package com.ushi.example.core.android.navigation

import android.app.Activity

interface NavigatorFactory {

    fun getNavigator(context: Activity): Navigator
}
