package com.ushi.example.modules

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ushi.example.core.android.navigation.Navigation
import com.ushi.example.core.android.navigation.Navigator
import com.ushi.example.core.android.navigation.NavigatorInterceptor
import com.ushi.example.core.android.navigation.Options
import com.ushi.example.core.android.navigation.ResultNavigation
import com.ushi.example.core.android.navigation.SingleNavigation
import com.ushi.example.feature.about.AboutFragment
import com.ushi.example.modules.databinding.ActivityMainBinding
import com.ushi.example.modules.ui.main.MainFragment

class MainActivity : AppCompatActivity(), NavigatorInterceptor {

    companion object {

        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.appbarBinding.toolbar)

        binding.bottomNav.setOnNavigationItemSelectedListener { selectNavigation(it.itemId) }
        binding.bottomNav.setOnNavigationItemReselectedListener {
            selectNavigation(it.itemId, true)
        }

        if (savedInstanceState == null) {
            binding.bottomNav.selectedItemId = R.id.menu_tab_1
        }
    }

    private fun selectNavigation(menuItemId: Int, reselected: Boolean = false): Boolean {
        val fragment: Fragment = when (menuItemId) {
            R.id.menu_tab_1 -> MainFragment.newInstance()
            R.id.menu_tab_2 -> AboutFragment.newInstance()
            else -> return false
        }

        if (!fragment.javaClass.isInstance(supportFragmentManager.primaryNavigationFragment)) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
        }

        return true
    }

    override fun getNavigatorOverlay(): Navigator.Overlay {
        return object: Navigator.Overlay() {
            override fun main(): Navigation<Unit>? {
                return object : SingleNavigation {
                    override fun navigate(options: Options?) {
                        binding.bottomNav.selectedItemId = R.id.menu_tab_1
                    }
                }
            }
        }
    }
}
