package com.ushi.example.feature.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ushi.example.core.android.navigation.Navigators
import com.ushi.example.feature.about.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    companion object {

        fun newInstance() = AboutFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAboutBinding.inflate(inflater, container, false)

        binding.buttonGoToMain.setOnClickListener {
            Navigators.find(this).main().navigate()
        }

        return binding.root
    }
}
