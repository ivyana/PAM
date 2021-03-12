package com.ivyana.lab1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val MAIN_REQUEST_CODE = 100
        const val NUMBER1_KEY = "NUMBER1_KEY"
        const val NUMBER2_KEY = "NUMBER2_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainButton.setOnClickListener {
            val number1 = number1EditText.text.toString()
            val number2 = number2EditText.text.toString()

            if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)) {
                Toast.makeText(this@MainActivity, "Please, choose 2 numbers:)", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intentMain = Intent(this, AddActivity::class.java)
            intentMain.putExtra(NUMBER1_KEY, number1)
            intentMain.putExtra(NUMBER2_KEY, number2)
            startActivityForResult(intentMain, MAIN_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MAIN_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data!!.getIntExtra(AddActivity.SUM_KEY, 0)
                resultTextView.text = result.toString()
            }
        } else {
            Toast.makeText(this@MainActivity, "No result:(", Toast.LENGTH_LONG).show()
        }
    }
}
