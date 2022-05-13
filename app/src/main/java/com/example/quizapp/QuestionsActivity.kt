package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {
    private var name:String ?= null
    private var score:Int = 0

    private var currentPosition:Int = 1
    private var queList:ArrayList<QuestionData> ?= null
    private var selectedOptionNo:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        name = intent.getStringExtra(SetData.name)

/*      [Testing using logs in logcat]

        var demo = SetData.getQuestion()
        Log.e("my test","${demo.size}")
*/

/*     [Testing using que1 statement & option1 click]

        var queList:ArrayList<QuestionData> ?= null
        queList = SetData.getQuestion()
        var que = queList!![0]
        questionText.text = que.question
        opt1.text = que.optionOne

                   // on clicking the option, highlight
        opt1.setOnClickListener{        // setting drawable of selected option
            opt1.background = ContextCompat.getDrawable(this, R.drawable.selected_question_option)
        }

        opt2.text = que.optionTwo
        opt3.text = que.optionThree
        opt4.text = que.optionFour

        progressBar.progress = 1
        progressBar.max = queList!!.size
 */
        queList = SetData.getQuestion()    // getting all questions
        setQuestion()

        opt1.setOnClickListener{
            selectedOptionStyle(opt1,1)
            selectedOptionNo = 1
        }
        opt2.setOnClickListener{
            selectedOptionStyle(opt2,2)
            selectedOptionNo = 2
        }
        opt3.setOnClickListener{
            selectedOptionStyle(opt3,3)
            selectedOptionNo = 3
        }
        opt4.setOnClickListener{
            selectedOptionStyle(opt4,4)
            selectedOptionNo = 4
        }

        submit.setOnClickListener{
            if(selectedOptionNo != 0) {
                val que = queList!![currentPosition-1]

                if(selectedOptionNo != que.correctAns)    // 2nd argument (R.drawable.correc...) is an integer value
                setOptionColor(selectedOptionNo, R.drawable.wrong_question_option)
                else
                score++

                setOptionColor(que.correctAns, R.drawable.correct_question_option)

                if(currentPosition == queList!!.size)
                submit.text = "Finish"
                else
                submit.text = "Go To Next Question"
            }
            else if(submit.text == "Submit"){
                val que = queList!![currentPosition-1]
                setOptionColor(que.correctAns, R.drawable.correct_question_option)

                if(currentPosition == queList!!.size)
                submit.text = "Finish"
                else
                submit.text = "Go To Next Question"
            }
            else{
                currentPosition++

                if(submit.text == "Go To Next Question")
                submit.text = "Submit"

                when{
                    (currentPosition<=queList!!.size) -> {
                        setQuestion()
                    }
                    else -> {
                      //  Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()
                        var intent  = Intent(this,Result::class.java)
                        intent.putExtra(SetData.name, name.toString())    // mapping of type vs value of data passed
                        intent.putExtra(SetData.score, score.toString())
                        intent.putExtra("MaxScore", queList!!.size.toString())
                        startActivity(intent)
                        finish()      // this page work is finished
                    }
                }
            }

            selectedOptionNo = 0
        }
    }

    fun setQuestion(){
        val que = queList!![currentPosition-1]
        setOptionStyle()

        progressBar.progress = currentPosition
        progressBar.max = queList!!.size
        progressText.text = "${currentPosition}/${queList!!.size}"

        questionText.text = que.question
        opt1.text = que.optionOne
        opt2.text = que.optionTwo
        opt3.text = que.optionThree
        opt4.text = que.optionFour
    }

    fun setOptionStyle(){
        var optList:ArrayList<TextView> = arrayListOf()
        optList.add(0,opt1)
        optList.add(1,opt2)
        optList.add(2,opt3)
        optList.add(3,opt4)

        for(opt in optList)
        {
            opt.setTextColor(Color.parseColor("#555151"))
            opt.background = ContextCompat.getDrawable(this,R.drawable.question_option)
            opt.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(opt:TextView,optNo:Int){
        setOptionStyle()        // make other options as normal bcz single correct que, not multi correct que
        selectedOptionNo = optNo
        opt.background = ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        opt.typeface = Typeface.DEFAULT_BOLD
        opt.setTextColor(Color.parseColor("#000000"))
    }

    fun setOptionColor(opt:Int,color:Int){
        when(opt){     // switch case in Kotlin
             1->{
                 opt1.background = ContextCompat.getDrawable(this,color)
             }
             2->{
                 opt2.background = ContextCompat.getDrawable(this,color)
             }
            3->{
                opt3.background = ContextCompat.getDrawable(this,color)
            }
            4->{
                opt4.background = ContextCompat.getDrawable(this,color)
            }
        }
    }
}