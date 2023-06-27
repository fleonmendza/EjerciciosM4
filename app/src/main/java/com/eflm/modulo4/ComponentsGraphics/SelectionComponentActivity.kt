package com.eflm.modulo4.ComponentsGraphics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import com.eflm.modulo4.R

class SelectionComponentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_component)

        val cbTc = findViewById<CheckBox>(R.id.cbTarjeta)
        val btSend = findViewById<Button>(R.id.btSend)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)

        //CheeckBox
        cbTc.setOnCheckedChangeListener { view, isChecked ->
            Toast.makeText(this, "Con tarjeta = ${isChecked}", Toast.LENGTH_SHORT).show()
        }

        //RadioButton
        rgSex.setOnCheckedChangeListener { view, checkedId ->
            val idName = when(checkedId){
                R.id.rbHombre -> cbTc.visibility = View.VISIBLE
                R.id.rbMujer -> cbTc.visibility = View.INVISIBLE
                else -> "Desconocido"
            }
            Toast.makeText(this, "isCheckedId = $idName", Toast.LENGTH_SHORT).show()
        }

        //Spiner
        val spinner = findViewById<Spinner>(R.id.spinner)
        val datos = arrayListOf("Mexico", "Espana", "Dinamarca", "Belgica", "Brazil", "Colombia")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, datos)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
             val itemSelected = datos[position]
                Toast.makeText(this@SelectionComponentActivity, "item selecionado = $itemSelected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@SelectionComponentActivity, "Nada selecionado", Toast.LENGTH_SHORT).show()
            }

        }



        //Bonton
        btSend.setOnClickListener {
            val status = cbTc.isChecked
            val rgSelet = when(rgSex.checkedRadioButtonId){
                R.id.rbHombre -> "H"
                R.id.rbMujer -> "M"
                else -> "Desconocido"
            }
            Toast.makeText(this, "isChecked = $rgSelet", Toast.LENGTH_SHORT).show()

        }
    }
}