package com.ushi.example.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ushi.example.feature.session.SessionActivity
import com.ushi.example.feature.speaker.SpeakerActivity
import com.ushi.example.modules.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.appbarBinding.toolbar)

        binding.buttonGoSpeaker.setOnClickListener {
            startActivity(SpeakerActivity.newIntent(this, 51))
        }

        binding.buttonGoSession.setOnClickListener {
            startActivity(SessionActivity.newIntent(this, 1))
        }
    }
}
