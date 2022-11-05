package com.vkunitsyn.level2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vkunitsyn.level2.databinding.ContactModelLayoutBinding
import com.vkunitsyn.level2.model.ContactModel
import com.vkunitsyn.level2.utils.addPictureGlide


class ContactsAdapter(contacts: List<ContactModel>) :
    RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {
    private lateinit var binding: ContactModelLayoutBinding
    private var contactsList = contacts

    class MyViewHolder(binding: ContactModelLayoutBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ContactModelLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        binding.apply {
            tvModelUserName.text = contactsList[position].name
            tvUserModelCareer.text = contactsList[position].career
            ivModelProfilePicture.addPictureGlide(contactsList[position].picture_URL)
        }
    }

    override fun getItemCount(): Int = contactsList.size

    fun refreshList(contacts: List<ContactModel>){
        contactsList = contacts
        notifyDataSetChanged()
    }



}