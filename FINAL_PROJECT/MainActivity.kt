package com.example.final_project_ilmhona

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.final_project_ilmhona.databinding.ActivityMainBinding
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /////Create animation for activity_main (transitions from different gradinet items)/////

        var mainLayout: ConstraintLayout = findViewById(R.id.main_layout)

        var animation: AnimationDrawable = mainLayout.background as AnimationDrawable
        animation.setEnterFadeDuration(3000)
        animation.setExitFadeDuration(5000)
        animation.start()


        var startTriviaButton: MaterialCardView = findViewById(R.id.start_button)

        startTriviaButton.setOnClickListener {
            var intent = Intent(this, TriviaCards::class.java)
            startActivity(intent)
            finish()
        }

    }
}