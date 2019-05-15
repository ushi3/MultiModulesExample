package com.ushi.example.feature.session

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ushi.example.core.android.BaseActivity
import com.ushi.example.core.android.navigation.Navigators
import com.ushi.example.feature.session.databinding.ActivitySessionBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class SessionActivity : BaseActivity() {

    companion object {

        private const val EXTRA_ID = "id"

        fun newIntent(context: Context, id: Int) =
            Intent(context, SessionActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
    }

    private lateinit var binding: ActivitySessionBinding

    private lateinit var viewModel: SessionViewModel

    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_session)

        setSupportActionBar(binding.appbarBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProviders.of(this).get(SessionViewModel::class.java)
        viewModel.init(intent.getIntExtra(EXTRA_ID, -1))

        binding.speakerIcon.setOnClickListener {
            viewModel.getSpeaker().subscribe { speaker ->
                Navigators.find(this).speaker(speaker.id).navigate()
            }
        }

        load()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }

    private fun load() {
        disposable.add(
            viewModel.load()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { session ->
                        binding.session = session
                    },
                    { e ->
                        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
                    }
                )
        )
    }
}