package com.vkunitsyn.level2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.vkunitsyn.level2.adapter.ContactsAdapter
import com.vkunitsyn.level2.databinding.ActivityContactsBinding
import com.vkunitsyn.level2.model.ContactModel
import com.vkunitsyn.level2.utils.ContactsViewModel

class ContactsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactsBinding
    private lateinit var adapter: ContactsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: ContactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ContactsViewModel::class.java)
        initAdapter()
        processBackArrowClick()
        processSearchClick()
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

    private fun processSearchClick() {
        binding.ibSearch.setOnClickListener {
            viewModel.changeData()
            adapter.refresh(viewModel.getData())
        }
    }

    private fun initAdapter() {
        recyclerView = binding.rvContacts
        adapter = ContactsAdapter(viewModel.getData())
        recyclerView.adapter = adapter
    }

}