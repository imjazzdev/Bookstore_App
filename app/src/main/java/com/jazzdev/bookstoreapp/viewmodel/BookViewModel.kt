package com.jazzdev.bookstoreapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jazzdev.bookstoreapp.data.model.Book
import com.jazzdev.bookstoreapp.R

class BookViewModel : ViewModel() {

    private val _bookList  = MutableLiveData<List<Book>>().apply {
        value = listOf(
            Book("Filosofi Teras", "Henry Manampiring", R.drawable.book1),
            Book("Sapiens", "Yuval Noah", R.drawable.book2),
            Book("Dunia Shopie", "Jostein Gaarder", R.drawable.book3),
            Book("Homo Deus", "Yuval Noah", R.drawable.book4)
        )
    }

    val bookList: LiveData<List<Book>> = _bookList

    fun toggleWishlist(position: Int) {
        val currentList = _bookList.value?.toMutableList() ?: return
        currentList[position].isInWishlist = !currentList[position].isInWishlist
        _bookList.value = currentList
    }
}