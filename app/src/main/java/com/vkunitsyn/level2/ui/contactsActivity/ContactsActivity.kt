package com.vkunitsyn.level2.ui.contactsActivity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.vkunitsyn.level2.R
import com.vkunitsyn.level2.adapter.ContactsAdapter
import com.vkunitsyn.level2.databinding.ActivityContactsBinding
import com.vkunitsyn.level2.ui.AddContactFragment

class ContactsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactsBinding
    lateinit var adapter: ContactsAdapter

    private val viewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.contactsList.observe(this) { adapter.refresh(it) }
        initAdapter()
        processBackArrowClick()
        processAddContactClick()
        enableSwipeToDelete()
    }


    private fun enableSwipeToDelete() {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                v: RecyclerView,
                h: RecyclerView.ViewHolder,
                t: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(h: RecyclerView.ViewHolder, dir: Int) {
                adapter.removeAt(h.adapterPosition)
            }
        }).attachToRecyclerView(binding.rvContacts)
    }


    private fun processAddContactClick() {
        binding.tvAddContact.setOnClickListener {
            AddContactFragment().show(supportFragmentManager, getString(R.string.tv_add_contact))
        }
    }

    private fun processBackArrowClick() {
        binding.ibArrowBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }


    private fun initAdapter() {
        adapter = ContactsAdapter()
        binding.rvContacts.adapter = adapter
    }

}



