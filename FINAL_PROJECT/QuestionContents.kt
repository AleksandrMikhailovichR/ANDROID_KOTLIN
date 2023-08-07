package com.example.final_project_ilmhona

object QuestionContents {

    const val TOTAL_QUESTIONS: String = "total_questions"
    const val RIGHT_ANSWERS: String = "right_answers"

    fun getQuestions(): ArrayList<Questions>{

        var questionItems = ArrayList<Questions>()

        val q1 = Questions(1,
            "What geometric shape is generally used for stop signs?",
            "Hexagon",
            "Octagon",
            "Circle",
            "Triangle",
            2)

        questionItems.add(q1)

        val q2 = Questions(2,
            "What is the shape of the toy invented by Hungarian professor Ernő Rubik?",
            "Cube",
            "Sphere",
            "Cylinder",
            "Pyramid",
            1)

        questionItems.add(q2)

        val q3 = Questions(3,
            "What are Panama hats made out of?",
            "Silk",
            "Hemp",
            "Flax",
            "Straw",
            4)

        questionItems.add(q3)

        val q4 = Questions(4,
            "What is the nickname of the US state of California?",
            "Golden State",
            "Sunshine State",
            "Bay State",
            "Treasure State",
            4)

        questionItems.add(q4)

        val q5 = Questions(5,
            "What does a funambulist walk on?",
            "Broken Glass",
            "Balls",
            "A Tight Rope",
            "The Moon",
            3)

        questionItems.add(q5)

        val q6 = Questions(6,
            "When was the Playstation 3 released?",
            "January 8, 2007",
            "December 25, 2007",
            "July 16, 2006",
            "November 11, 2006",
            4)

        questionItems.add(q6)

        val q7 = Questions(7,
            "How tall is the Burj Khalifa?",
            "2,717 ft",
            "2,722 ft",
            "2,546 ft",
            "3,024 ft",
            2)

        questionItems.add(q7)

        val q8 = Questions(8,
            "What do the letters in the GMT time zone stand for?",
            "Greenwich Mean Time",
            "Global Meridian Time",
            "General Median Time",
            "Glasgow Man Time",
            1)

        questionItems.add(q8)

        val q9 = Questions(9,
            "Which American president appears on a one dollar bill?",
            "Thomas Jefferson",
            "Abraham Lincoln",
            "George Washington",
            "Benjamin Franklin",
            3)

        questionItems.add(q9)

        val q10 = Questions(10,
            "What nuts are used in the production of marzipan?",
            "Peanuts",
            "Walnuts",
            "Pistachios",
            "Almonds",
            4)

        questionItems.add(q10)

        return questionItems
    }
}