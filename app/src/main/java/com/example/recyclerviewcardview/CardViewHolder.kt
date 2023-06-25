package com.example.recyclerviewcardview

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewcardview.databinding.CardCellBinding
import com.squareup.picasso.Picasso

class CardViewHolder(
    private val cardCellBinding: CardCellBinding, private val clickListener: BookClickListener
) : RecyclerView.ViewHolder(cardCellBinding.root) {
    fun bindBook(book: Book) {
        Picasso.get().load(book.picture).into(cardCellBinding.cover)
        cardCellBinding.title.text = book.title
        cardCellBinding.author.text = book.author
        cardCellBinding.cardView.setOnClickListener {
            clickListener.onClick(book)
        }
    }
}