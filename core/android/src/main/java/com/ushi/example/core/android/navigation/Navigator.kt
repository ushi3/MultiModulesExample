package com.ushi.example.core.android.navigation

interface Navigator {

    fun speaker(userId: Int): Navigation<Unit>

    fun speakerList(): Navigation<Unit>

    fun session(sessionId: Int): Navigation<Unit>

    fun sessionList(): Navigation<Unit>
}
