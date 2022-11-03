package com.vkunitsyn.level2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.vkunitsyn.level2.model.ContactModel

class  ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {

    var contactsList = emptyList<ContactModel>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return contactsList.size
    }


}