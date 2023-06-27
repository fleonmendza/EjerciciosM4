package com.eflm.modulo4.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.eflm.modulo4.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btStart = findViewById<Button>(R.id.btStart)

        btStart.setOnClickListener {
            val firtsIntent = Intent(this, FirstActivity::class.java )
            startActivity(firtsIntent)
        }
    }
}