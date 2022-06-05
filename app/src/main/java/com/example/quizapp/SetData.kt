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
            "Which of the following are applications of Topological Sort of a graph?",
            "Sentence Ordering",
            "Course Scheduling",
            "OS Deadlock Detection",
            "All of the above",
            4
        )

        var que2 = QuestionData(
            2,
            "Maps in C++ are implemented using which of the following data structures?",
            "Red Black Trees",
            "Binary Search Trees",
            "AVL Trees",
            "Hash Tables",
            1
        )

        var que3 = QuestionData(
            3,
            "What is the time complexity in precomputation & check prime of the Sieve of Eratosthenes algorithm?",
            "O(n) & O(1)",
            "O(nlog(logn)) & O(1)",
            "O(nlogn) & O(1)",
            "O(n) & O(logn)",
            2
        )

        var que4 = QuestionData(
            1,
            "Which of the following algorithms are used for processing queries on trees?",
            "Centroid Decomposition",
            "Heavy Light Decomposition",
            "All of the above",
            "None of the above",
            3
        )

        var que5 = QuestionData(
            1,
            "What is the space complexity in memorization & brute force (recursive) solution of the nth Fibonacci algorithm?",
            "O(n) & O(2^n)",
            "O(n) & O(n)",
            "O(2^n) & O(2^n)",
            "O(2^n) & O(n)",
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





