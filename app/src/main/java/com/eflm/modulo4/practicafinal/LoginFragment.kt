package com.eflm.modulo4.practicafinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eflm.modulo4.R
import com.eflm.modulo4.Tarea1.DataActivity
import com.eflm.modulo4.databinding.FragmentLoginBinding
import com.eflm.modulo4.fragments.SecondFragment
import com.google.android.material.snackbar.Snackbar


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.linkTextView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmen_container_autentication, SingInUpFragment.newInstance())
                .addToBackStack("SingInUpFragment")
                .commit()
        }

        val email = binding.ipLEmail.text
        val password = binding.ipLPassword.text

        fun showSnackbar(message: String) {
            Snackbar.make(binding.MainLogin, message, Snackbar.LENGTH_SHORT).show()
        }


        binding.btLogin.setOnClickListener {
            if (email.isEmpty()) {
                showSnackbar("Ingresa un correo para iniciar sesion")
            } else if (password.isEmpty()) {
                showSnackbar("Ingresa una contrasena")
            } else {
                val dataIntent = Intent(requireContext(), HomeActivity::class.java).apply {
                    putExtra("EXTRA_EMAIL", "$email")
                    putExtra("EXTRA_PASSWORD", "$password")
                }
                startActivity(dataIntent)

            }
        }
    }


    companion object {

        @JvmStatic
        fun newInstance() = LoginFragment()

    }


}