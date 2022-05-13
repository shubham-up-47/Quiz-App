package com.example.quizapp

data class QuestionData (
    var id:Int,
    var question:String,
    var optionOne:String,
    var optionTwo:String,
    var optionThree:String,
    var optionFour:String,
    var correctAns:Int
)