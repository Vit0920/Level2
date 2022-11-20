package com.vkunitsyn.level2.utils

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.addPictureGlide(path: String) {
    Glide.with(this)
        .load(path)
        .circleCrop()
        .override(400, 400)
        .into(this)
}

fun ImageView.addPictureGlide(drawable: Int) {
    Glide.with(this)
        .load(drawable)
        .circleCrop()
        .override(400, 400)
        .into(this)
}

fun ImageView.addPictureGlide(uri: Uri) {
    Glide.with(this)
        .load(uri)
        .circleCrop()
        .override(400, 400)
        .into(this)
}