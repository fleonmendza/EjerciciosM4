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
import com.eflm.modulo4.databinding.ActivitySelectionComponentBinding
import com.eflm.modulo4.databinding.ItemAnimalBinding

class SelectionComponentActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectionComponentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionComponentBinding.inflate(layoutInflater)

        setContentView(binding.root)
//        setContentView(R.layout.activity_selection_component)

//        val cbTc = findViewById<CheckBox>(R.id.cbTarjeta)
//        val btSend = findViewById<Button>(R.id.btSend)
//        val rgSex = findViewById<RadioGroup>(R.id.rgSex)

        //CheeckBox
        binding.cbTarjeta.setOnCheckedChangeListener { view, isChecked ->
            Toast.makeText(this, "Con tarjeta = $isChecked", Toast.LENGTH_SHORT).show()
        }

        //RadioButton
        binding.rgSex.setOnCheckedChangeListener { view, checkedId ->
            val idName = when(checkedId){
                R.id.rbHombre -> binding.cbTarjeta.visibility = View.VISIBLE
                R.id.rbMujer -> binding.cbTarjeta.visibility = View.INVISIBLE
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
       binding.btSend.setOnClickListener {
            val status = binding.cbTarjeta.isChecked
            val rgSelet = when(binding.rgSex.checkedRadioButtonId){
                R.id.rbHombre -> "H"
                R.id.rbMujer -> "M"
                else -> "Desconocido"
            }
            Toast.makeText(this, "isChecked = $rgSelet", Toast.LENGTH_SHORT).show()

        }
    }
}