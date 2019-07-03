package com.ushi.example.modules

import android.app.Application
import android.content.Context
import com.ushi.example.core.android.navigation.Navigation
import com.ushi.example.core.android.navigation.Navigator
import com.ushi.example.core.android.navigation.Options
import com.ushi.example.core.android.navigation.SingleNavigation
import com.ushi.example.feature.session.SessionActivity
import com.ushi.example.feature.speaker.SpeakerActivity


class AppNavigator(private val context: Context) : Navigator {

    override fun main() = object : SingleNavigation {
        override fun navigate(options: Options?) {
            context.startActivity(MainActivity.newIntent(context))
        }
    }

    override fun speaker(userId: Int) = object : SingleNavigation {
        override fun navigate(options: Options?) {
            context.startActivity(SpeakerActivity.newIntent(context, userId))
        }
    }

    override fun speakerList() = object : SingleNavigation {
        override fun navigate(options: Options?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun session(sessionId: Int) = object : SingleNavigation {
        override fun navigate(options: Options?) {
            context.startActivity(SessionActivity.newIntent(context, sessionId))
        }
    }

    override fun sessionList() = object : SingleNavigation {
        override fun navigate(options: Options?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun about() = object : SingleNavigation {
        override fun navigate(options: Options?) {
            // FIXME fix: launch Main mode about
            context.startActivity(MainActivity.newIntent(context))
        }
    }
}
