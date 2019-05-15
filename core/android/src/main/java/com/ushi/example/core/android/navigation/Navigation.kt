package com.ushi.example.core.android.navigation

import android.content.Intent
import com.ushi.example.core.android.R
import java.lang.UnsupportedOperationException

interface Navigation<R> {

    fun navigate(options: Options? = null)

    fun withResult() : ResultNavigation<R>
}

interface SingleNavigation : Navigation<Unit> {

    override fun withResult(): ResultNavigation<Unit> = throw UnsupportedOperationException()
}

interface ResultNavigation<R> {

    fun navigate(requestCode: Int, options: Options? = null)

    fun resultFrom(data: Intent?): R?
}
