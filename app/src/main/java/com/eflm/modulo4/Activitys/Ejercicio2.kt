package com.eflm.modulo4.Activitys

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.eflm.modulo4.R

class Ejercicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        val button = findViewById<Button>(R.id.btSend)
        val buttonUrl = findViewById<Button>(R.id.btUrl)

        button.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Aviso urgente")
                putExtra(Intent.EXTRA_TEXT, "Esta es una prueba de un correo con intent implicito")
            }
            startActivity(Intent.createChooser(emailIntent, "enviar email usando..."))
        }

        buttonUrl.setOnClickListener {
            val url = Intent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/")))
            startActivity(url)
        }

    }
}