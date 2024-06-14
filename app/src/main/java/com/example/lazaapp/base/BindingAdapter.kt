package com.example.lazaapp.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.lazaapp.utils.setImageFromUrl

@BindingAdapter("load_image_local")
fun setImageSrc(imageView: ImageView, resId: Int) {
    imageView.setImageResource(resId)
}

@BindingAdapter("setImageFromUrl")
fun setImageFromUrl(imageView: ImageView, url: String?){
    url?.let {
        imageView.setImageFromUrl(it)
    }
}