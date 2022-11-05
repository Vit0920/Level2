package com.vkunitsyn.level2.utils

import android.service.autofill.UserData
import androidx.lifecycle.ViewModel
import com.vkunitsyn.level2.model.ContactModel

var contactsList: List<ContactModel> = mutableListOf()

class ContactsViewModel : ViewModel() {
    init {
        contactsList = ContactsData.getData()
    }

   fun getData() : List<ContactModel> = contactsList

    fun changeData() {
        contactsList = ContactsData.getAnotherData()
    }
}