package com.vkunitsyn.level2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vkunitsyn.level2.databinding.ActivityAddContactBinding

class AddContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        processBackArrowClick()
    }

    private fun processBackArrowClick() {
        binding.ibArrowBackAddContact.setOnClickListener {
            finish()
        }
    }
}