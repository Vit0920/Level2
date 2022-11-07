package com.vkunitsyn.level2.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.vkunitsyn.level2.adapter.ContactsAdapter
import com.vkunitsyn.level2.databinding.ActivityContactsBinding
import com.vkunitsyn.level2.utils.ContactsViewModel

class ContactsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactsBinding
    private lateinit var adapter: ContactsAdapter
    private val viewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.contactsList.observe(this, { it?.let { it -> adapter.refresh(it) } })
        initAdapter()
        processBackArrowClick()
        processSearchClick()
        processAddContactClick()
        enableSwipeToDelete()


    }

    private fun enableSwipeToDelete() {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        override fun onMove(v: RecyclerView, h: RecyclerView.ViewHolder, t: RecyclerView.ViewHolder) = false
        override fun onSwiped(h: RecyclerView.ViewHolder, dir: Int) {
            val deletedContact = adapter.contactsList.get(h.adapterPosition)
            val position = h.adapterPosition
            adapter.removeAt(h.adapterPosition)
            Snackbar.make(binding.rvContacts, "Deleted " + deletedContact.name, Snackbar.LENGTH_LONG)
                .setAction(
                    "Undo",
                    View.OnClickListener {
                        // adding on click listener to our action of snack bar.
                        // below line is to add our item to array list with a position.
                        adapter.contactsList.add(position, deletedContact)

                        // below line is to notify item is
                        // added to our adapter class.
                        adapter.notifyItemInserted(position)
                    }).show()
        }
    }).attachToRecyclerView(binding.rvContacts)
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
            viewModel.getData()?.let { it1 -> adapter.refresh(it1) }
        }
    }

    private fun initAdapter() {
        adapter = ContactsAdapter()
        binding.rvContacts.adapter = adapter
    }

}