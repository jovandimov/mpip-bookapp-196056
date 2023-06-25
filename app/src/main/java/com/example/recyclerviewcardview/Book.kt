package com.example.recyclerviewcardview

import java.io.Serializable

var bookList = mutableListOf<Book>()

val BOOK_ID_EXTRA = "bookExtra"

class Book(
    var author: String,
    var title: String,
    var description: String,
    val picture: String,
    val id: Int? = bookList.size,
) : Serializable

