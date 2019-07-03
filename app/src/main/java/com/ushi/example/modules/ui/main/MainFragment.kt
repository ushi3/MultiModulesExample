package com.ushi.example.modules.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ushi.example.core.android.navigation.Navigators
import com.ushi.example.feature.session.SessionActivity
import com.ushi.example.feature.speaker.SpeakerActivity
import com.ushi.example.modules.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {

        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.buttonGoSpeaker.setOnClickListener {
            startActivity(SpeakerActivity.newIntent(requireContext(), 51))
        }

        binding.buttonGoSession.setOnClickListener {
            startActivity(SessionActivity.newIntent(requireContext(), 1))
        }

        binding.buttonGoAbout.setOnClickListener {
            Navigators.find(this).about().navigate()
        }

        return binding.root
    }


}