package com.ushi.example.core.android

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onSupportNavigateUp(): Boolean {
        if (!super.onSupportNavigateUp()) {
            onBackPressed()
        }
        return true
    }
}
