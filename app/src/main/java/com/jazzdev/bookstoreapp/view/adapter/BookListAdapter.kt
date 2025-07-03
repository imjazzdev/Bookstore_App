package com.jazzdev.bookstoreapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jazzdev.bookstoreapp.data.model.Book
import com.jazzdev.bookstoreapp.databinding.BookItemBinding
import com.jazzdev.bookstoreapp.R

class BookListAdapter(
    private val onWishlistToggle: (Int) -> Unit
) : RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {

    private var books: List<Book> = emptyList()

    fun submitList(newList: List<Book>) {
        books = newList
        notifyDataSetChanged()
    }

    inner class BookViewHolder(private val binding: BookItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book, position: Int) {

            binding.bookImage.setImageResource(book.imageResId)
            binding.bookTitle.text = book.title
            binding.bookAuthor.text = book.author

            val buttonText = if (book.isInWishlist)
                R.string.remove_from_wishlist_btn_text
            else
                R.string.add_to_wishlist_btn_text

            binding.wishlistButton.text = binding.root.context.getString(buttonText)

            binding.wishlistButton.setOnClickListener {
                onWishlistToggle(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position], position)
    }

    override fun getItemCount(): Int = books.size
}