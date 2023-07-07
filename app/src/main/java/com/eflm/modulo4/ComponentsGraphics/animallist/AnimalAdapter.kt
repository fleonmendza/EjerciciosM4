package com.eflm.modulo4.ComponentsGraphics.animallist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.eflm.modulo4.R
import com.squareup.picasso.Picasso

class AnimalAdapter(private  val list:List<Animal>): RecyclerView.Adapter<AnimalViewHolder>() {

    var onItemSelected : ((Animal)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.render(list[position], onItemSelected)
    }
}

class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val root = view.findViewById<ConstraintLayout>(R.id.root)
    val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
    val tvAnimalName = view.findViewById<TextView>(R.id.tvAnimalName)
    fun render(animal: Animal, onItemSelected: ((Animal)-> Unit)?){
        tvAnimalName.text = animal.name
        root.setOnClickListener{
            onItemSelected?.invoke(animal)
        }
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV6D8fJZWgcW5SpV0ZnF8XTOmCcY1C1wCRPU9LJ-MzQFMPqiPkPw87OMcIQe7IM3WQVnw&usqp=CAU")
            .error(R.drawable.ic_people)
            .placeholder(R.drawable.img_logo)
            .into(ivAnimal)
    }
}