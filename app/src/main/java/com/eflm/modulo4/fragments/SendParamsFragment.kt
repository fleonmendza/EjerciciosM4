package com.eflm.modulo4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eflm.modulo4.ComponentsGraphics.animallist.Animal
import com.eflm.modulo4.R
import com.eflm.modulo4.databinding.FragmentSendParamsBinding


class SendParamsFragment : Fragment(R.layout.fragment_send_params) {

private lateinit var binding: FragmentSendParamsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSendParamsBinding.bind(view)

        binding.btSendData.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack("ReciveParamsFragment")
                .replace(R.id.fragmentParams, ReciveParamsFragment.newInstance("fede"
//                    , Animal("leon", "azul")
                ))
                .commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = SendParamsFragment

    }
}