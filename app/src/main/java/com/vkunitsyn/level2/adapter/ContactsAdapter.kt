package com.vkunitsyn.level2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vkunitsyn.level2.databinding.ContactModelLayoutBinding
import com.vkunitsyn.level2.model.ContactModel
import com.vkunitsyn.level2.utils.addPictureGlide


class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {
    private lateinit var binding: ContactModelLayoutBinding
    var contactsList: ArrayList<ContactModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ContactModelLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = contactsList.size


    fun refresh(contacts: ArrayList<ContactModel>){
        this.contactsList = contacts
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        contactsList.removeAt(position)   // items is a MutableList
        notifyItemRemoved(position)
    }

    inner class MyViewHolder(binding: ContactModelLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                tvModelUserName.text = contactsList[position].name
                tvUserModelCareer.text = contactsList[position].career
                ivModelProfilePicture.addPictureGlide(contactsList[position].picture_URL)
                btnDelete.setOnClickListener { removeAt(position) }
            }
        }

    }


}