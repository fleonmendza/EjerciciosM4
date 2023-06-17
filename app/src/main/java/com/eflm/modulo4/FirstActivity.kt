package com.eflm.modulo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class FirstActivity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        if(result.resultCode == RESULT_OK){
            val name = result.data?.getStringExtra("EXTRA_NAME")
            val lastName = result.data?.getStringExtra("EXTRA_LASTNAME")
            val age = result.data?.getIntExtra("EXTRA_AGE", 0)
            Toast.makeText(this, "resultCode = ${result.resultCode} EXTRA_IS_OK = ${result.data?.getBooleanExtra("EXTRA_IS_OK",
                false)} \n Mi nombre es: ${name} \n Mi apellido es: ${lastName} \n Mi edad: ${age}", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "CANCELED", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btSCActy = findViewById<Button>(R.id.btOpenSeconActy)

        btSCActy.setOnClickListener {
            val secondIntent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME", "Fede")
                putExtra("EXTRA_LASTNAME", "Leon")
                putExtra("EXTRA_AGE", 24)
            }
              startActivity(secondIntent)
            register.launch(secondIntent)
        }
    }


}