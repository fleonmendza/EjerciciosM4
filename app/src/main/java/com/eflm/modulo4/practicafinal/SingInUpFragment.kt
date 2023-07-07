package com.eflm.modulo4.practicafinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eflm.modulo4.R
import com.eflm.modulo4.databinding.FragmentLoginBinding
import com.eflm.modulo4.databinding.FragmentSingInUpBinding
import com.google.android.material.snackbar.Snackbar


class SingInUpFragment : Fragment(R.layout.fragment_sing_in_up) {


    private lateinit var binding: FragmentSingInUpBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSingInUpBinding.bind(view)

        val inputName = binding.ipRName.text
        val inputLastName = binding.ipRLastName.text
        val inputEmail = binding.ipREmail.text
        var sexInput = ""
        val inputPassword = binding.ipRPassword.text
        //RadioGroup
        binding.rgRSex.setOnCheckedChangeListener { view, checkedId ->
            when(checkedId){
                binding.rbRHombre.id -> {sexInput = "Hombre"}
                binding.rbRMujer.id-> {sexInput = "Mujer" }
                else -> "Desconocido"
            }
        }

        fun showSnackbar(message: String) {
            Snackbar.make(binding.MainSignUp, message, Snackbar.LENGTH_SHORT).show()
        }

        binding.btRegister.setOnClickListener {
            if (inputName.isEmpty()){
                showSnackbar("Ingresa un nombre")
            }
            else if (inputLastName.isEmpty()){
              showSnackbar( "Ingresa tus apellidos")
            }
            else if (inputEmail.isEmpty()){
                showSnackbar("Ingresa un correo")

            }
            else if (sexInput.isEmpty()){
             showSnackbar( "Seleciona un sexo")
            }
            else if (inputPassword.isEmpty()){
                showSnackbar("Ingresa una contrasena")
            }
           else {
                val dataIntent = Intent(requireContext(), HomeActivity::class.java).apply {
                    putExtra("EXTRA_EMAIL", "$inputEmail")
                    putExtra("EXTRA_PASSWORD", "$inputPassword")
                }
                startActivity(dataIntent)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = SingInUpFragment()

    }
}