package com.example.que.ui.storage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.que.R
import com.example.que.data.model.Quote
import com.example.que.databinding.ListQuoteItemBinding

class QuotesAdapter(private val context: Context?, private val quoteList: List<Quote>) :
    RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val view = ListQuoteItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return QuotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        val quote = quoteList[position]
        holder.bind(quote)
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

    inner class QuotesViewHolder(private val itemBinding: ListQuoteItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(quote: Quote) {
            itemBinding.tvQuoteContent.text =
                context?.getString(R.string.quote_format, quote.content)
            itemBinding.tvQuoteAuthor.text = quote.author
        }
    }
}