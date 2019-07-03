package com.ushi.example.core.android.navigation

interface Navigator {

    fun main(): Navigation<Unit>

    fun speaker(userId: Int): Navigation<Unit>

    fun speakerList(): Navigation<Unit>

    fun session(sessionId: Int): Navigation<Unit>

    fun sessionList(): Navigation<Unit>

    fun about(): Navigation<Unit>

    open class Overlay {

        open fun main(): Navigation<Unit>? = null

        open fun about(): Navigation<Unit>? = null
    }
}
