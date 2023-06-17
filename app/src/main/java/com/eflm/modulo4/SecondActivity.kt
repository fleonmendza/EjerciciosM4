package com.eflm.modulo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("EXTRA_NAME")
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val age = intent.getIntExtra("EXTRA_AGE",0)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastName = findViewById<TextView>(R.id.tvLastName)
        val tvAge = findViewById<TextView>(R.id.tvAge)

        tvName.text = name
        tvLastName.text = lastName
        tvAge.text = age.toString()

        val btBack = findViewById<Button>(R.id.btBack)
        btBack.setOnClickListener {
            val returnIntent = Intent().apply {
                putExtra("EXTRA_IS_TRUE", true)
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_LASTNAME", lastName)
                putExtra("EXTRA_AGE", age)
            }
            setResult(RESULT_OK, returnIntent)
            finish()
        }

    }
}