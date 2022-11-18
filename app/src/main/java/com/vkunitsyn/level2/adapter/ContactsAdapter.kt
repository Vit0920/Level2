package com.vkunitsyn.level2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.vkunitsyn.level2.R
import com.vkunitsyn.level2.databinding.ContactModelLayoutBinding
import com.vkunitsyn.level2.model.ContactModel
import com.vkunitsyn.level2.utils.addPictureGlide
import com.vkunitsyn.level2.viewmodels.ContactsViewModel


class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var context: Context
    private var contactsList: ArrayList<ContactModel> = ArrayList()


    inner class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var binding = ContactModelLayoutBinding.bind(item)
        fun bind(contact: ContactModel) = binding.apply {
            tvModelUserName.text = contact.name
            tvUserModelCareer.text = contact.career
            if(contact.picture.isEmpty()){
                ivModelProfilePicture.addPictureGlide(R.drawable.default_profile_picture)
            }else{
            ivModelProfilePicture.addPictureGlide(contact.picture)
            }
            btnDelete.setOnClickListener { removeAt(adapterPosition) }
        }
    }


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        myRecyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_model_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        context = holder.itemView.context
        holder.bind(contactsList[position])
    }

    override fun getItemCount(): Int = contactsList.size


    fun refresh(contacts: ArrayList<ContactModel>) {
        contactsList = contacts
    }

    fun removeAt(position: Int) {
        val deletedContact = contactsList[position]
        contactsList.removeAt(position)
        notifyItemRemoved(position)
        showSnackbar(deletedContact, position)
    }

    fun add(position: Int, contact: ContactModel) {
        contactsList.add(position, contact)
        notifyItemInserted(position)
    }

    private fun showSnackbar(contact: ContactModel, position: Int) {
        Snackbar.make(
            myRecyclerView,
            contact.name + context.getString(R.string.has_been_removed),
            Snackbar.LENGTH_LONG
        )
            .setAction(context.getString(R.string.undo)) {
                add(position, contact)
            }.show()
    }
}