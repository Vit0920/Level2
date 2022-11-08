package com.vkunitsyn.level2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.vkunitsyn.level2.R
import com.vkunitsyn.level2.databinding.FragmentAddContactBinding
import com.vkunitsyn.level2.model.ContactModel
import com.vkunitsyn.level2.viewmodels.ContactsViewModel

class AddContactFragment : DialogFragment() {

    lateinit var  binding: FragmentAddContactBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddContactBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        processSaveButtonClick()
        processBackArrowClick()
    }

    private fun processBackArrowClick() {
        binding.ibArrowBackAddContact.setOnClickListener { dismiss() }
    }

    private fun processSaveButtonClick() {

        binding.mbSaveAddContact.setOnClickListener{
            val position = (activity as ContactsActivity).adapter.itemCount
            (activity as ContactsActivity).adapter.add(position,createNewContact())
            dismiss()
        }
    }

    private fun createNewContact(): ContactModel {
        val newContact: ContactModel = ContactModel()
        with(newContact) {
            picture_URL = ""
            name = binding.tietUserNameAddContact.text.toString()
            career = binding.tietCareerAddContact.text.toString()
            phone = binding.tietPhoneAddContact.text.toString()
            address = binding.tietAddressAddContact.text.toString()
            birthday = binding.tietBirthdayAddContact.text.toString()
        }
      return newContact
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    companion object {
        fun newInstance() = AddContactFragment()
    }
}


