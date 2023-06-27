package com.eflm.modulo4.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.eflm.modulo4.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
        val btBack2 = findViewById<Button>(R.id.btBack2)
        btBack2.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                val returnIntent = Intent().apply {
                    putExtra("EXTRA_IS_TRUE", true)
                    putExtra("EXTRA_IS_ACTIVITY_BACK", true)
                }
                setResult(RESULT_OK, returnIntent)
                onBackPressedDispatcher.onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}