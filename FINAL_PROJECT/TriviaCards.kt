package com.example.final_project_ilmhona

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class TriviaCards: AppCompatActivity(), View.OnClickListener {

    private var mCurPosition: Int = 1
    private var mQuestList: ArrayList<Questions> ?= null
    private var mChosenVariantPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var option_1: TextView = findViewById(R.id.button1)
        var option_2: TextView = findViewById(R.id.button2)
        var option_3: TextView = findViewById(R.id.button3)
        var option_4: TextView = findViewById(R.id.button4)

        /////Get access to default questions created in "QuestionContents" object/////

        mQuestList = QuestionContents.getQuestions()

        setQuestions()

        option_1.setOnClickListener(this)
        option_2.setOnClickListener(this)
        option_3.setOnClickListener(this)
        option_4.setOnClickListener(this)

        /////Declare button for checking answer/////

        var send_button: Button = findViewById(R.id.submit_button)

        send_button.setOnClickListener(this)

    }

    private fun setQuestions(){

        /////Populate info from QuestionContents to template in activity_quiz layout by relevant position/////

        val question = mQuestList!!.get(mCurPosition-1)


        /////Display default view once new question is set/////

        primaryVariantsView()

        var send_button: Button = findViewById(R.id.submit_button)

        if(mCurPosition == mQuestList!!.size){
            send_button.text = "FINISH!"
        }
        else{
            send_button.text = "SUBMIT"
        }

        /////Declare progress bar view/text and assign starting value with further increment/////

        var progress_bar: ProgressBar = findViewById(R.id.progression_vw)
        progress_bar.progress = mCurPosition

        var progress_txt: TextView = findViewById(R.id.progression_txt)
        progress_txt.text = "${mCurPosition}" + "/" + progress_bar.max

        /////Declare question block and put value from QuestionContents/////

        var question_space: TextView = findViewById(R.id.question_block)
        question_space.text = question!!.triviaQuestion

        /////Do the same for the "options" objects/////

        var option_1: TextView = findViewById(R.id.button1)
        var option_2: TextView = findViewById(R.id.button2)
        var option_3: TextView = findViewById(R.id.button3)
        var option_4: TextView = findViewById(R.id.button4)

        option_1.text = question.variantOne
        option_2.text = question.variantTwo
        option_3.text = question.variantThree
        option_4.text = question.variantFour

    }

    private fun primaryVariantsView(){
        val variants = ArrayList<TextView>()

        var option_1: TextView = findViewById(R.id.button1)
        var option_2: TextView = findViewById(R.id.button2)
        var option_3: TextView = findViewById(R.id.button3)
        var option_4: TextView = findViewById(R.id.button4)

        variants.add(0, option_1)
        variants.add(1, option_2)
        variants.add(2, option_3)
        variants.add(3, option_4)

        for(option in variants){
            option.setTextColor(Color.parseColor("#354DCF"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_variant)
        }
    }

    override fun onClick(p0: View?) {

        var option_1: TextView = findViewById(R.id.button1)
        var option_2: TextView = findViewById(R.id.button2)
        var option_3: TextView = findViewById(R.id.button3)
        var option_4: TextView = findViewById(R.id.button4)

        var send_button: Button = findViewById(R.id.submit_button)

        when(p0?.id){
            R.id.button1 -> {
                selectedVariantView(option_1, 1)
            }
            R.id.button2 -> {
                selectedVariantView(option_2, 2)
            }
            R.id.button3 -> {
                selectedVariantView(option_3, 3)
            }
            R.id.button4 -> {
                selectedVariantView(option_4, 4)
            }
            R.id.submit_button -> {
                if(mChosenVariantPosition == 0){
                    mCurPosition++

                    when{
                        mCurPosition <= mQuestList!!.size -> {
                            setQuestions()
                        }
                    else -> {

                        val intent = Intent(this, FinalScore::class.java)
                        intent.putExtra(QuestionContents.RIGHT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(QuestionContents.TOTAL_QUESTIONS, mQuestList!!.size)
                        startActivity(intent)
                        finish()

                        }
                    }
                }
                else{
                    val question = mQuestList?.get(mCurPosition-1)
                    if(question!!.rightAnswer != mChosenVariantPosition){
                        answerDisplay(mChosenVariantPosition, R.drawable.wrong_highlight_button )
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerDisplay(question.rightAnswer, R.drawable.correct_highlight_button)

                    if(mCurPosition == mQuestList!!.size){
                        send_button.text = "FINISH!"
                    }
                    else{
                        send_button.text = "GO NEXT"
                    }
                    mChosenVariantPosition == 0
                }
            }
        }
    }

    private fun answerDisplay(answer: Int, highlight: Int){

        var option_1: TextView = findViewById(R.id.button1)
        var option_2: TextView = findViewById(R.id.button2)
        var option_3: TextView = findViewById(R.id.button3)
        var option_4: TextView = findViewById(R.id.button4)

        when(answer){

            1 -> {
                option_1.background = ContextCompat.getDrawable(this, highlight)
            }

            2 -> {
                option_2.background = ContextCompat.getDrawable(this, highlight)
            }

            3 -> {
                option_3.background = ContextCompat.getDrawable(this, highlight)
            }

            4 -> {
                option_4.background = ContextCompat.getDrawable(this, highlight)
            }

        }

    }

    private fun selectedVariantView(stance: TextView, chosenOptionNum: Int){

        /////Reset previous variant if clicked several times/////
        primaryVariantsView()

        mChosenVariantPosition = chosenOptionNum


        stance.setTextColor(Color.parseColor("#354DCF"))
        stance.setTypeface(stance.typeface, Typeface.BOLD)
        stance.background = ContextCompat.getDrawable(this, R.drawable.selected_variant)

    }
    
}