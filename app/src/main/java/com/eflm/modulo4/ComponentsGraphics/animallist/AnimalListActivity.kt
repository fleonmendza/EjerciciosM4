package com.eflm.modulo4.ComponentsGraphics.animallist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eflm.modulo4.R

class AnimalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        val list = findViewById<RecyclerView>(R.id.AnimalList)

        val animalList = listOf(Animal("Leon", "Amarillo"),
                                Animal("Jirafa", "Amarillo"),
                                Animal("Cocodrilo", "Verde"),
                                Animal("Conejo", "Blanco"))

        val adapter = AnimalAdapter(animalList)
        adapter.onItemSelected = {
            animal ->
            Toast.makeText(this, "${animal.name}", Toast.LENGTH_SHORT).show()
        }
        list.adapter = adapter
        list.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}