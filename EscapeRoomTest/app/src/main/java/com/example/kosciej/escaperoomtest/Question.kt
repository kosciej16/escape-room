package com.example.kosciej.escaperoomtest

open class Question(val question: String)

class ClosedQuestion(question: String, val answers: List<String>): Question(question) {
}

class QuestionFactory() {
    companion object {
        fun create(): MutableList<Question> {
            val questions = mutableListOf<Question>()
            questions.add(ClosedQuestion(
                "Zadanie 1 - stolicą Liechtenstein jest",
                listOf("Podgorica", "Talinn", "Vaduz", "Ankara")))
            questions.add(Question("Ile milionów ludzi jest w Europie?"))
            questions.add(ClosedQuestion("Zadanie 3 - Który z nich nie był nigdy prezydentem Francji?\"",
                listOf("Emmanuel Macron", "Édouard Philippe", "François Hollande", "Nicolas Sarkozy")))
            questions.add(Question("Zadanie 4 - Ile lat Polska była pod zaborami?"))
            return questions
        }
    }
}