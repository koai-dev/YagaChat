package com.rbservice.yaga.base

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

@BindingAdapter("thumb_shape")
fun setImageShape(shapeableImageView: ShapeableImageView, imageUrl: String?){
    if (imageUrl!=null){
        Glide.with(shapeableImageView).load(imageUrl).into(shapeableImageView)
    }
}

@SuppressLint("UseCompatLoadingForDrawables")
@BindingAdapter("icon")
fun setIcon(imageView: ImageView, icon: Int?){
    if (icon!=null){
        imageView.setImageDrawable(imageView.resources.getDrawable(icon, imageView.resources.newTheme()))
    }
}