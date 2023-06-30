package com.eflm.modulo4.Tarea1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import com.eflm.modulo4.Activitys.SecondActivity
import com.eflm.modulo4.R
import com.google.android.material.snackbar.Snackbar

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val user = findViewById<EditText>(R.id.ipRName)
        val lastName = findViewById<EditText>(R.id.ipRLastName)
        val email = findViewById<EditText>(R.id.ipREmail)
        val sex = findViewById<RadioGroup>(R.id.rgRSex)
        val password = findViewById<EditText>(R.id.ipRPassword)
        val btRegister = findViewById<Button>(R.id.btRegister)
        val main = findViewById<ConstraintLayout>(R.id.Main)

        val userInput = user.text
        val lastNameInput = lastName.text
        val emailInput = email.text
        var sexInput = ""
        val passwordInput = password.text

    //RadioGroup
       sex.setOnCheckedChangeListener { view, checkedId ->
           when(checkedId){
                R.id.rbRHombre -> {sexInput = "Hombre"}
                R.id.rbRMujer -> {sexInput = "Mujer" }
                else -> "Desconocido"
            }
        }

    //Boton registrar
        btRegister.setOnClickListener {
            if (user.text.isEmpty()){
                Snackbar.make(main, "Ingresa tu nombre", Snackbar.LENGTH_SHORT).show()
            }
            else if (lastName.text.isEmpty()){
                Snackbar.make(main, "Ingresa tus apellidos", Snackbar.LENGTH_SHORT).show()
            }
            else if (email.text.isEmpty()){
                Snackbar.make(main, "Ingresa un correo electronico", Snackbar.LENGTH_SHORT).show()
            }
            else if (sexInput.isEmpty()){
                Snackbar.make(main, "Seleciona un sexo", Snackbar.LENGTH_SHORT).show()
            }
            else if (password.text.isEmpty()){
                Snackbar.make(main, "Ingresa una contrasena", Snackbar.LENGTH_SHORT).show()
            }
            else{
                val dataIntent = Intent(this, DataActivity::class.java).apply {
                    putExtra("EXTRA_NAME", "$userInput")
                    putExtra("EXTRA_LASTNAME", "$lastNameInput")
                    putExtra("EXTRA_EMAIL", "$emailInput")
                    putExtra("EXTRA_SEX", "$sexInput")
                    putExtra("EXTRA_PASSWORD", "$passwordInput")
                }

                startActivity(dataIntent)

            }

        }
    }


}