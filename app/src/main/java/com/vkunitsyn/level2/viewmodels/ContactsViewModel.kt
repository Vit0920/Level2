package com.vkunitsyn.level2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vkunitsyn.level2.model.ContactModel
import com.vkunitsyn.level2.utils.ContactsData

class ContactsViewModel : ViewModel() {

    val contactsList: MutableLiveData<ArrayList<ContactModel>> by lazy {
        MutableLiveData<ArrayList<ContactModel>>()
    }

    init {
        contactsList.value = ContactsData.getData()
    }

}