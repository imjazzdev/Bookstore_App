package com.jazzdev.bookstoreapp.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jazzdev.bookstoreapp.R
import com.jazzdev.bookstoreapp.view.adapter.BookListAdapter
import com.jazzdev.bookstoreapp.viewmodel.BookViewModel
import com.jazzdev.bookstoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BookViewModel by viewModels()
    private lateinit var adapter: BookListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBookList()
    }

    private fun setupBookList() {
        adapter = BookListAdapter { position ->
            viewModel.toggleWishlist(position)
        }

        binding.bookList.layoutManager = LinearLayoutManager(this)
        binding.bookList.adapter = adapter

        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.bookList.addItemDecoration(decoration)

        viewModel.bookList.observe(this) {
            adapter.submitList(it)
        }
    }
}