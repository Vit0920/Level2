package com.vkunitsyn.level2.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vkunitsyn.level2.model.ContactModel



class ContactsViewModel : ViewModel() {

    val contactsList: MutableLiveData<ArrayList<ContactModel>> by lazy {
        MutableLiveData<ArrayList<ContactModel>>()
    }

    init {
        contactsList.value = ContactsData.getData()
    }

   fun getData()  = contactsList.value

    fun changeData() {
        contactsList.value = ContactsData.getAnotherData()
    }
}