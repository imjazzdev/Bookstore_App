package com.jazzdev.bookstoreapp.data.model

data class Book(
    val title: String,
    val author: String,
    val imageResId: Int,
    var isInWishlist: Boolean = false // toggle status wishlist
)