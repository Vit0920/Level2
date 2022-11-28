package com.vkunitsyn.level2.ui.contactsActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vkunitsyn.level2.model.Contact
import com.vkunitsyn.level2.utils.ContactsData

class ContactsViewModel : ViewModel() {


    val contactsList: MutableLiveData<ArrayList<Contact>> by lazy {
        MutableLiveData<ArrayList<Contact>>()
    }

    init {
        contactsList.value = ContactsData.getData()
    }

}