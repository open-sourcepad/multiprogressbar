package com.sourcepad.multiprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.sourcepad.core.multiprogressbar.MultiProgressBar

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {


    private lateinit var multiProgressBar: MultiProgressBar

    private lateinit var all: SeekBar
    private lateinit var p1: SeekBar
    private lateinit var p2: SeekBar
    private lateinit var p3: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        all = findViewById(R.id.overall_seekbar)
        p1 = findViewById(R.id.progress1_seekbar)
        p2 = findViewById(R.id.progress2_seekbar)
        p3 = findViewById(R.id.progress3_seekbar)

        multiProgressBar = findViewById(R.id.progressbar)


        all.setOnSeekBarChangeListener(this)
        p1.setOnSeekBarChangeListener(this)
        p2.setOnSeekBarChangeListener(this)
        p3.setOnSeekBarChangeListener(this)

        setTitle(R.string.multiprogressbar)

//        multiProgressBar.setColor(R.color.green, R.color.pink, R.color.blue)

    }


    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        when (seekBar?.id) {
            R.id.overall_seekbar -> {
                val overallProgress = all.progress.toFloat()
                multiProgressBar.setProgress(overallProgress, overallProgress, overallProgress)

                p1.progress = overallProgress.toInt()
                p2.progress = overallProgress.toInt()
                p3.progress = overallProgress.toInt()
            }

            R.id.progress1_seekbar -> {
                val overallProgress = seekBar.progress.toFloat()
                multiProgressBar.setProgress(progress1 = overallProgress)
            }
            R.id.progress2_seekbar -> {
                val overallProgress = seekBar.progress.toFloat()
                multiProgressBar.setProgress(progress2 = overallProgress)
            }
            R.id.progress3_seekbar -> {
                val overallProgress = seekBar.progress.toFloat()
                multiProgressBar.setProgress(progress3 = overallProgress)
            }
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }
}
