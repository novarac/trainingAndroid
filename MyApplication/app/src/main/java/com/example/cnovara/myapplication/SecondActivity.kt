package com.example.cnovara.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity: AppCompatActivity() {

    val RESULT_CODE_BACK = 1
    var nameTextView: TextView? = null
    var backButton: Button? = null
    var backResultText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nameTextView = this.findViewById(R.id.nameTextView)
        backButton = this.findViewById(R.id.backButton)
        backResultText = this.findViewById(R.id.resultBackText)
        nameTextView?.text = intent.getStringExtra("nameText")

        backButton?.setOnClickListener(View.OnClickListener {
            intent.putExtra("resultText", "hola ${backResultText?.text}")
            setResult(RESULT_CODE_BACK)
            finish()
        })
    }
}