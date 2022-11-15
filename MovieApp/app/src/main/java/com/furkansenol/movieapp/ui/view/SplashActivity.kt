package com.furkansenol.movieapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.furkansenol.movieapp.R
import kotlinx.android.synthetic.main.activity_splash.*

private lateinit var timer:CountDownTimer

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()

        animationView.playAnimation()
//        animationView.loop(true)

        timer = object : CountDownTimer(2500, 1000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                val intent = Intent(this@SplashActivity, NewsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }

    override fun onStop() {
        super.onStop()
        animationView.cancelAnimation()
        timer.cancel()
    }
}