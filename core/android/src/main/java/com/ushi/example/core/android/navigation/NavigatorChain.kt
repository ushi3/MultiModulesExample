package com.ushi.example.core.android.navigation

internal class NavigatorChain(
    private val navigator: Navigator,
    private val dispatcher: Navigator.Overlay) : Navigator {

    override fun main(): Navigation<Unit> = dispatcher.main() ?: navigator.main()

    override fun speaker(userId: Int): Navigation<Unit> = navigator.speaker(userId)

    override fun speakerList(): Navigation<Unit> = navigator.speakerList()

    override fun session(sessionId: Int): Navigation<Unit> = navigator.session(sessionId)

    override fun sessionList(): Navigation<Unit> = navigator.sessionList()

    override fun about(): Navigation<Unit> = dispatcher.about() ?: navigator.about()
}
