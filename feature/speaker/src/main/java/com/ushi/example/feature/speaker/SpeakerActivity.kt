package com.ushi.example.feature.speaker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ushi.example.core.android.BaseActivity
import com.ushi.example.core.android.navigation.Navigators
import com.ushi.example.feature.speaker.databinding.ActivitySpeakerBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class SpeakerActivity : BaseActivity() {

    companion object {

        private const val EXTRA_ID = "id"

        fun newIntent(context: Context, id: Int) =
            Intent(context, SpeakerActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
    }

    private lateinit var binding: ActivitySpeakerBinding

    private lateinit var viewModel: SpeakerViewModel

    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_speaker)

        setSupportActionBar(binding.appbarBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProviders.of(this).get(SpeakerViewModel::class.java)
        viewModel.init(intent.getIntExtra(EXTRA_ID, -1))

        binding.buttonSession.setOnClickListener {
            viewModel.get().subscribe { speakerDetail ->
                Navigators.find(this).session(speakerDetail.sessions.first().id).navigate()
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
                    { speaker -> binding.speaker = speaker },
                    { e ->
                        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
                    }
                )
        )
    }

}
