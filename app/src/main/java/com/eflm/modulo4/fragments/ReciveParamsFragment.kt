package com.eflm.modulo4.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eflm.modulo4.Activitys.FirstActivity
import com.eflm.modulo4.ComponentsGraphics.animallist.Animal
import com.eflm.modulo4.R
import com.eflm.modulo4.databinding.FragmentReciveParamsBinding
import com.eflm.modulo4.databinding.FragmentSendParamsBinding

class ReciveParamsFragment : Fragment(R.layout.fragment_recive_params) {
  private lateinit var binding: FragmentReciveParamsBinding
  private var name: String? = ""
//    private var animal : Animal? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("ARG_NAME")
//            animal= it.getSerializable("ARG_ANIMAL") as Animal
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReciveParamsBinding.bind(view)

        binding.tvname.text=name
//        binding.tvanimal.text=animal?.name

        binding.btSendtActivity.setOnClickListener {
            val intent = Intent(requireContext(), FirstActivity::class.java).apply {
                putExtra("EXTRA_NAME", name)
            }
            startActivity(intent)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String
//                        animal: Animal
        ) = ReciveParamsFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_NAME", name)
//                    putSerializable("ARG_NAME", animal)
                }
            }
    }
}