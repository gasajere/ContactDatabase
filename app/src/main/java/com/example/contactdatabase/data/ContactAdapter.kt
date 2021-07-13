package com.example.contactdatabase.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactdatabase.databinding.ContactItemBinding

class ContactAdapter(private val contacts:List<ContactItem>,
                     val clickfun:(ContactItem) -> Unit):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>()  {
   inner class ContactViewHolder(private val binding:ContactItemBinding)
       :RecyclerView.ViewHolder(binding.root) {
        fun bind (current: ContactItem){
            binding.first.text = current.firstname
            binding.last.text = current.lastname
            binding.phone.text = current.phone1
            binding.root.setOnClickListener{
                clickfun(current)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding: ContactItemBinding=
            ContactItemBinding.inflate(LayoutInflater.from(parent.context))
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentCon= contacts[position]
        holder.bind(currentCon)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}
