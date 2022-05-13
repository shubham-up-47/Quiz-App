package com.example.quizapp

object SetData
{
    const val name:String = "name"
    const val score:String = "score"

    fun getQuestion():ArrayList<QuestionData>
    {
        var questions:ArrayList<QuestionData> = arrayListOf()    // empty array

        var que1 = QuestionData(
            1,
            "Pick the correct statement:",
            "Mae Swapnil ke saath jaunga",
            "Mae Vikas ke saath jaungi",
            "Mae Swapnil ke sath jaungi",
            "Mae Vikas ke saath jaunga",
            3
        )

        var que2 = QuestionData(
            2,
            "Yash's dream place:",
            "Mumbai",
            "America",
            "Munnar",
            "Noida",
            4
        )

        var que3 = QuestionData(
            3,
            "Class that changed Vikas's life:",
            "Class 9th",
            "Class 10th",
            "Class 11th",
            "Class 12th",
            1
        )

        var que4 = QuestionData(
            1,
            "IPL teams which Kiran hates & likes the most:",
            "RR and MI",
            "CSK and GT",
            "RR and GT",
            "MI and CSK",
            3
        )

        var que5 = QuestionData(
            1,
            "Vipul's favourite TA:",
            "AS",
            "AG",
            "UM",
            "RD",
            2
        )

        questions.add(que1)
        questions.add(que2)
        questions.add(que3)
        questions.add(que4)
        questions.add(que5)
        return questions               // returning filled array
    }
}





