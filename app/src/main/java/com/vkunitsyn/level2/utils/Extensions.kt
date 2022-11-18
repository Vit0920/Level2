package com.vkunitsyn.level2.utils

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.addPictureGlide(picture: Any?) {
    Glide.with(this)
        .load(picture)
        .circleCrop()
        .override(200, 200)
        .into(this)
}

//fun ImageView.addPictureGlide(drawable: Int) {
//    Glide.with(this)
//        .load(drawable)
//        .circleCrop()
//        .override(200, 200)
//        .into(this)
//}
//
//fun ImageView.addPictureGlide(drawable: Drawable) {
//    Glide.with(this)
//        .load(drawable)
//        .circleCrop()
//        .override(200, 200)
//        .into(this)
//}
//
//fun ImageView.addPictureGlide(uri: Uri) {
//    Glide.with(this)
//        .load(uri)
//        .circleCrop()
//        .override(200, 200)
//        .into(this)
//}