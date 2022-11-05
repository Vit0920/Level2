package com.vkunitsyn.level2.utils

import androidx.lifecycle.ViewModel
import com.vkunitsyn.level2.model.ContactModel

var contactsList: MutableList<ContactModel> = mutableListOf()

class ContactsViewModel : ViewModel() {
    init {
        contactsList = mutableListOf(
            ContactModel(
                "https://avatarko.ru/img/kartinka/2/zhivotnye_kot_sobaka_prikol_1764.jpg",
                "Vasya", "Doctor"
            ),
            ContactModel(
                "https://avatarko.ru/img/kartinka/33/kapyushon_robot_34631.jpg",
                "Petya", "Teacher"
            ),
            ContactModel(
                "https://avatarko.ru/img/kartinka/11/multfilm_robot_10393.jpg",
                "Anna", "Designer"
            ),
            ContactModel(
                "https://avatarko.ru/img/kartinka/18/devushka_robot_17109.jpg",
                "Lisa", "Cook"
            )
        )
    }

   fun getData() : MutableList<ContactModel> = contactsList

    fun changeData() {
        contactsList = mutableListOf(
            ContactModel(
                "https://avatarko.ru/img/kartinka/2/zhivotnye_kot_sobaka_prikol_1764.jpg",
                "Vasya", "Doctor"
            ),
            ContactModel(
                "https://avatarko.ru/img/kartinka/33/kapyushon_robot_34631.jpg",
                "Petya", "Teacher"
            ),
            ContactModel(
                "https://avatarko.ru/img/kartinka/11/multfilm_robot_10393.jpg",
                "Anna", "Designer"
            )
        )
    }
}