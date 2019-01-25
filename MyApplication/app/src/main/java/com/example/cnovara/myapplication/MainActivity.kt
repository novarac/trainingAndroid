package com.example.cnovara.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var goButton: Button? = null
    var nameText: EditText? = null
    var resultTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goButton = this.findViewById(R.id.goButton)
        nameText = this.findViewById(R.id.nameText)
        resultTextView = this.findViewById(R.id.resultTextView)

        goButton?.setOnClickListener(
            View.OnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("nameText", "hola ${nameText?.text}")
                startActivityForResult(intent, 1)
            }
        )
    }

    override fun onResume() {
        super.onResume()

        resultTextView?.setVisibility(GONE)
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        resultTextView?.setText("hola ${intent?.getStringExtra("resultText")}")
        resultTextView?.setVisibility(VISIBLE)
    }
}