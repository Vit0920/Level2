package com.vkunitsyn.level2.ui

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.vkunitsyn.level2.R
import com.vkunitsyn.level2.databinding.FragmentAddContactBinding
import com.vkunitsyn.level2.model.ContactModel
import com.vkunitsyn.level2.utils.addPictureGlide

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
        binding.ivNewContactPicture.addPictureGlide(R.drawable.profile_image)
        processSaveButtonClick()
        processBackArrowClick()
        processAddPictureClick()
    }

    private fun processAddPictureClick() {
        binding.ibAddPicture.setOnClickListener{
           val startCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(startCameraIntent)
        }
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
        val newContact = ContactModel()
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
}


