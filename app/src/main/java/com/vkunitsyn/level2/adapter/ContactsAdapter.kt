package com.vkunitsyn.level2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vkunitsyn.level2.databinding.ContactModelLayoutBinding
import com.vkunitsyn.level2.model.ContactModel


class  ContactsAdapter(contacts: List<ContactModel>) : RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {
    private lateinit var binding: ContactModelLayoutBinding
    private var contactsList = contacts

    class MyViewHolder(binding: ContactModelLayoutBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ContactModelLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        binding.tvModelUserName.text = contactsList[position].name
        binding.tvUserModelCareer.text = contactsList[position].career
        Glide.with(binding.ivModelProfilePicture)
            .load(contactsList[position].picture_URL)
            .circleCrop()
            .override(200,200)
            .into(binding.ivModelProfilePicture)


    }

    override fun getItemCount(): Int = contactsList.size
}