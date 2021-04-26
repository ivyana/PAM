package com.ivyana.lab1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity: AppCompatActivity() {

    companion object {
        const val SUM_KEY = "SUM_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val number1 = intent.getStringExtra(MainActivity.NUMBER1_KEY)
        val number2 = intent.getStringExtra(MainActivity.NUMBER2_KEY)

        number1TextView.text = number1.toString()
        number2TextView.text = number2.toString()

        addButton.setOnClickListener {
            val sum = number1.toInt() + number2.toInt()

            val intentAdd = Intent()
            intentAdd.putExtra(SUM_KEY, sum)
            setResult(Activity.RESULT_OK, intentAdd)

            finish()
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()
    }
}