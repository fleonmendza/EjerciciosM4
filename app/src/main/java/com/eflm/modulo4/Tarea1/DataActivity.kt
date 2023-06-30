package com.eflm.modulo4.Tarea1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.eflm.modulo4.R

class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val name = intent.getStringExtra("EXTRA_NAME")
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val sex = intent.getStringExtra("EXTRA_SEX")
        val password = intent.getStringExtra("EXTRA_PASSWORD")

        val tvName = findViewById<TextView>(R.id.tvDRName)
        val tvLastName = findViewById<TextView>(R.id.tvDRLastName)
        val tvEmail = findViewById<TextView>(R.id.tvDREmail)
        val tvSex = findViewById<TextView>(R.id.tvDRSexo)
        val tvPassword = findViewById<TextView>(R.id.tvDRPassword)

        tvName.text = name
        tvLastName.text = lastName
        tvEmail.text = email
        tvSex.text = sex
        tvPassword.text = password
    }
}