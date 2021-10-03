package com.example.que.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.que.data.model.Quote

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quotes")
    fun getAllQuotes(): LiveData<List<Quote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Query("DELETE FROM quotes")
    suspend fun deleteAllQuotes()

}