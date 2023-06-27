package com.eflm.modulo4.ComponentsGraphics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eflm.modulo4.R

class RecicleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicle)


        val rvPerson = findViewById<RecyclerView>(R.id.personList)
        val personAdapter = PersonAdapter(arrayListOf(
            Person("1", "Juan", "Esta es la descripcion de una persona ramdom en una lista conv varias personas"),
            Person("2", "Andres", "Esta es la descripcion de una persona ramdom en una lista conv varias personas"),
            Person("3", "Marco", "Esta es la descripcion de una persona ramdom en una lista conv varias personas"),
            Person("1", "Juan", "Esta es la descripcion de una persona ramdom en una lista conv varias personas"),
            Person("2", "Andres", "Esta es la descripcion de una persona ramdom en una lista conv varias personas"),
            Person("3", "Marco", "Esta es la descripcion de una persona ramdom en una lista conv varias personas"),
            Person("1", "Juan", "Esta es la descripcion de una persona ramdom en una lista conv varias personas"),
            Person("2", "Andres", "Esta es la descripcion de una persona ramdom en una lista conv varias personas"),
            Person("3", "Marco", "Esta es la descripcion de una persona ramdom en una lista conv varias personas")
        ))



        rvPerson.adapter = personAdapter
        rvPerson.layoutManager= LinearLayoutManager(this)
    }




}