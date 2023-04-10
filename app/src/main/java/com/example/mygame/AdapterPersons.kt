package com.example.mygame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterPersons(private val mList: ArrayList<DataSelectPerson>) : RecyclerView.Adapter<AdapterPersons.ViewHolder>() {

    private lateinit var mListener: onItemCLickListener

    interface onItemCLickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener:onItemCLickListener){
        mListener=listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_select_person, parent, false)
        return ViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int ) {
        val Persons = mList[position]
        holder.Photo.setImageResource(Persons.Photo)
        holder.name.text = Persons.name
        holder.RazmerRuki.text = Persons.RazmerRuki
        holder.Sila.text = Persons.Sila
        holder.Lovkost.text = Persons.Lovkost
        holder.Intelekt.text = Persons.Intelekt
        holder.opisanie.text = Persons.opisanie

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View, listener: onItemCLickListener) : RecyclerView.ViewHolder(itemView) {
        val Photo: ImageView = itemView.findViewById(R.id.ivPhotoPersons)
        val name: TextView = itemView.findViewById(R.id.tvName)
        val RazmerRuki: TextView = itemView.findViewById(R.id.tvNumberRazmer)
        val Sila: TextView = itemView.findViewById(R.id.tvNumberSila)
        val Lovkost: TextView = itemView.findViewById(R.id.tvNumberLovkost)
        val Intelekt: TextView =itemView.findViewById<Button?>(R.id.tvNumberIntelect)
        val opisanie : TextView =itemView.findViewById<Button?>(R.id.tvOpisanie)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)

            }

        }


    }


}
