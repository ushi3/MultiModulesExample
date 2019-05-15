package com.ushi.example.repository.impl

import com.ushi.example.model.Session
import com.ushi.example.model.Speaker
import com.ushi.example.repository.R

object Data {

    internal val speakerA = Speaker(2, "山田太郎", R.drawable.ic_android_black_24dp)
    internal val speakerB = Speaker(51, "鈴木一朗", R.drawable.ic_person_black_24dp)

    object Sessions {
        internal val A = Session.Detail(
            0, "セッションA", "ほげほげ",
            speakerA
        )

        internal val B = Session.Detail(
            1, "セッションB", "ふがふが",
            speakerB
        )
    }

    object Speakers {

        internal val A_detail = Speaker.Detail(
            speakerA.id, speakerA.name, speakerA.imageRes,
            "@yys_dkbn",
            listOf(
                Session(Sessions.A.id, Sessions.A.title)
            )
        )

        internal val B_detail = Speaker.Detail(
            speakerB.id, speakerB.name, speakerB.imageRes,
            "@Ichiro51",
            listOf(
                Session(Sessions.B.id, Sessions.B.title)
            )
        )
    }

    val sessions = listOf(
        Sessions.A, Sessions.B
    )

    val speakers = listOf(
        Speakers.A_detail, Speakers.B_detail
    )

}