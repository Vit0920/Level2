package com.vkunitsyn.level2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.vkunitsyn.level2.databinding.ContactModelLayoutBinding
import com.vkunitsyn.level2.model.ContactModel
import com.vkunitsyn.level2.utils.addPictureGlide


class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {
    private lateinit var binding: ContactModelLayoutBinding
    private lateinit var myRecyclerView: RecyclerView
    var contactsList: ArrayList<ContactModel> = ArrayList()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        myRecyclerView = recyclerView
    }

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
    }

    fun removeAt(position: Int) {
        val deletedContact = contactsList[position]
        contactsList.removeAt(position)   // items is a MutableList
        notifyItemRemoved(position)
        Snackbar.make(myRecyclerView,
            "Deleted " + deletedContact.name,
            Snackbar.LENGTH_LONG
        )
            .setAction("Undo") {
               contactsList.add(position, deletedContact)
               notifyItemInserted(position)
            }.show()
    }

    inner class MyViewHolder(binding: ContactModelLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                tvModelUserName.text = contactsList[position].name
                tvUserModelCareer.text = contactsList[position].career
                ivModelProfilePicture.addPictureGlide(contactsList[position].picture_URL)
                btnDelete.setOnClickListener {
                    removeAt(position) }
            }
        }

    }


}