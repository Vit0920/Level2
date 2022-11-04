package com.vkunitsyn.level2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.RecyclerView
import com.vkunitsyn.level2.adapter.ContactsAdapter
import com.vkunitsyn.level2.databinding.ActivityContactsBinding
import com.vkunitsyn.level2.model.ContactModel

class ContactsActivity: AppCompatActivity() {
    private lateinit var binding: ActivityContactsBinding
    private lateinit var adapter: ContactsAdapter
    private lateinit var recyclerView: RecyclerView
    private var contactsList :  MutableList<ContactModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        loadData()
        processBackArrowClick()
        processAddContactClick()
    }

    private fun processAddContactClick() {
        binding.tvAddContact.setOnClickListener {
            val intent = Intent(this@ContactsActivity, AddContactActivity::class.java)
            startActivity(intent)
        }
    }

    private fun processBackArrowClick() {
        binding.ibArrowBack.setOnClickListener {
            finish()
        }
    }

    private fun initAdapter() {
        recyclerView = binding.rvContacts
        adapter = ContactsAdapter(contactsList)
        recyclerView.adapter = adapter
    }


    fun loadData(){
        contactsList.add(ContactModel(
            "https://avatarko.ru/img/kartinka/2/zhivotnye_kot_sobaka_prikol_1764.jpg",
            "Vasya","Doctor"))
        contactsList.add(ContactModel(
            "https://avatarko.ru/img/kartinka/33/kapyushon_robot_34631.jpg",
            "Petya","Teacher"))
        contactsList.add(ContactModel(
            "https://avatarko.ru/img/kartinka/11/multfilm_robot_10393.jpg",
            "Anna","Designer"))
        contactsList.add(ContactModel(
            "https://avatarko.ru/img/kartinka/18/devushka_robot_17109.jpg",
            "Lisa","Cook"))

    }

}