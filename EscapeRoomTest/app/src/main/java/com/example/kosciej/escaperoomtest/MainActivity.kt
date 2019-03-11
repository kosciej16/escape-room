package com.example.kosciej.escaperoomtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {

    val questions = QuestionFactory.create()
    var index = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun newGame(view: View?) {
        index = 0
        updateQuestion()
        next.setOnClickListener {nextQuestion()}
        next.text = "Następne pytanie"
    }

    fun nextQuestion() {
        if (optionGroup.checkedRadioButtonId == -1 && edit.text.toString() == "") {
            toast("Strzel przynajmniej!")
            return
        }
        optionGroup.clearCheck()
        index++
        if (index == questions.size - 1) {
            next.text = "Zakończ test"
        }
        if (index == questions.size) {
            showResult()
            return
        }
        updateQuestion()
    }

    fun showResult() {
        question.text = "Twój wynik to 27.5% - musisz się jeszcze trochę nauczyć!"
        next.text = "Zacznij od nowa"
        next.setOnClickListener {newGame(null)}
        edit.visibility = View.INVISIBLE
        optionGroup.visibility = View.INVISIBLE
    }

    fun updateQuestion() {
        val q = questions[index]
        question.text = q.question
        when (q) {
           is ClosedQuestion -> {
               val options = listOf<RadioButton>(option1, option2, option3, option4)
               options.forEachIndexed {index, it -> it.text = q.answers[index]}
               edit.visibility = View.INVISIBLE
               optionGroup.visibility = View.VISIBLE
           }
            else -> {
                edit.setText("")
                edit.visibility = View.VISIBLE
                optionGroup.visibility = View.INVISIBLE
            }
        }

    }
}
