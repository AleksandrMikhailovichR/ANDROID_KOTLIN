package com.example.final_project_ilmhona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalScore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_score)

        val totalQuestions = intent.getIntExtra(QuestionContents.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(QuestionContents.RIGHT_ANSWERS,0)

        var score: TextView = findViewById(R.id.score_text)
        score.text = "Your score is ${correctAnswers} out of ${totalQuestions}."

        var finish: Button = findViewById(R.id.finish_button)
        finish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}