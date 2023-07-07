package com.eflm.modulo4.practicafinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.eflm.modulo4.R
import com.eflm.modulo4.databinding.ActivityHome2Binding
import com.eflm.modulo4.databinding.FragmentLoginBinding

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)

        val email = intent.getStringExtra("EXTRA_EMAIL")
        val password = intent.getStringExtra("EXTRA_PASSWORD")

        val tvMail = findViewById<TextView>(R.id.tvHomeMail)
        val tvPassword = findViewById<TextView>(R.id.tvHomePassword)


        tvMail.text = email
        tvPassword.text = password
    }
}