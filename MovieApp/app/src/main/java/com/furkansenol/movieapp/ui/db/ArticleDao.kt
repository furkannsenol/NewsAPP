package com.furkansenol.movieapp.ui.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.furkansenol.movieapp.ui.models.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  upsert(article: Article):Long

    @Query("Select * FROM articles")
    fun getAllArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

}