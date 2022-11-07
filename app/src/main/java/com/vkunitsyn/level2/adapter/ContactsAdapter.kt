package com.vkunitsyn.level2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.vkunitsyn.level2.R
import com.vkunitsyn.level2.databinding.ContactModelLayoutBinding
import com.vkunitsyn.level2.model.ContactModel
import com.vkunitsyn.level2.utils.addPictureGlide


class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {
    private lateinit var binding: ContactModelLayoutBinding
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var context: Context
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
        context = holder.itemView.context
        holder.bind(position)
    }

    override fun getItemCount(): Int = contactsList.size


    fun refresh(contacts: ArrayList<ContactModel>){
        this.contactsList = contacts
    }

    fun removeAt(position: Int) {
        val deletedContact = contactsList[position]
        contactsList.removeAt(position)
        notifyItemRemoved(position)
        showSnackbar(deletedContact, position)
    }

    private fun add(position: Int, contact: ContactModel){
        contactsList.add(position, contact)
        notifyItemInserted(position)
    }

    private fun showSnackbar(contact: ContactModel, position: Int) {
        Snackbar.make(myRecyclerView,
            contact.name + context.getString(R.string.has_been_removed),
            Snackbar.LENGTH_LONG
        )
            .setAction(context.getString(R.string.undo)) {
                add(position, contact)
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