package com.vkunitsyn.level2.utils

import com.vkunitsyn.level2.model.ContactModel

object ContactsData {

   fun getData() = arrayListOf<ContactModel>(
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
           "https://avatarko.ru/img/kartinka/33/kapyushon_robot_34631.jpg",
           "Petya", "Teacher"
       ),
       ContactModel(
           "https://avatarko.ru/img/kartinka/11/multfilm_robot_10393.jpg",
           "Anna", "Designer"
       )

   )

    fun getAnotherData() = arrayListOf<ContactModel>(
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