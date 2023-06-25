package com.example.recyclerviewcardview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewcardview.databinding.ActivityAddBookBinding

class AddBookActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val author = binding.authorEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()
            val picture = binding.pictureUrl.text.toString()

            val newBook = Book(author, title, description, picture)

            val intent = Intent()
            intent.putExtra("newBook", newBook)
            setResult(RESULT_OK, intent)

            finish()
        }
    }
}