package com.vkunitsyn.level2.ui.contactsActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vkunitsyn.level2.model.Contact
import com.vkunitsyn.level2.utils.ContactsData

class ContactsViewModel : ViewModel() {


    private val _contactsList = MutableLiveData<List<Contact>>()
    val contactsList: LiveData<List<Contact>> = _contactsList


    init {
        _contactsList.value = ContactsData.getData()
    }

}