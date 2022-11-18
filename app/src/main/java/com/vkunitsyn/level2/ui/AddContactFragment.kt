package com.vkunitsyn.level2.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider.getUriForFile
import androidx.fragment.app.DialogFragment
import com.vkunitsyn.level2.R
import com.vkunitsyn.level2.databinding.FragmentAddContactBinding
import com.vkunitsyn.level2.model.ContactModel
import com.vkunitsyn.level2.utils.Constants
import com.vkunitsyn.level2.utils.addPictureGlide
import java.io.File


class AddContactFragment : DialogFragment() {

    lateinit var binding: FragmentAddContactBinding
    lateinit var getPhoto: ActivityResultLauncher<Intent>
    var outputFileUri: Uri? = null

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
        binding.ivNewContactPicture.addPictureGlide(R.drawable.default_profile_picture)
        processSaveButtonClick()
        processBackArrowClick()


        getPhoto = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                binding.ivNewContactPicture.addPictureGlide(outputFileUri)
            } else {
                outputFileUri = null
            }
        }
        processAddPictureClick()
    }


    private fun processAddPictureClick() {

        binding.ibAddPicture.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val image = createImageFile()

            outputFileUri = getUriForFile(
                requireContext(),
                Constants.AUTHORITIES, image
            )
            intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri)
            getPhoto.launch(intent)
        }
    }

    private fun createImageFile(): File {
        val imagePath = activity?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            Constants.NEW_CONTACT_PROFILE_PICTURE_FILE_NAME,
            "jpg",
            imagePath
        );
    }

    private fun processBackArrowClick() {
        binding.ibArrowBackAddContact.setOnClickListener { dismiss() }
    }

    private fun processSaveButtonClick() {

        binding.mbSaveAddContact.setOnClickListener {
            val position = (activity as ContactsActivity).adapter.itemCount
            (activity as ContactsActivity).adapter.add(position, createNewContact())
            dismiss()
        }
    }

    private fun createNewContact(): ContactModel {
        val newContact = ContactModel()
        with(newContact) {
            if (outputFileUri != null) {
                picture = outputFileUri.toString()
            }
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


