package com.ivyana.movieapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.runner.RunWith
import androidx.test.runner.AndroidJUnit4
import com.ivyana.movieapp.data.local.MovieDao
import com.ivyana.movieapp.data.local.MovieDatabase
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException
import com.ivyana.movieapp.models.Result
import com.google.common.truth.Truth.assertThat

@RunWith(AndroidJUnit4::class)
class SpendsDatabaseTest : TestCase() {

    private lateinit var movieDao: MovieDao
    private lateinit var db: MovieDatabase

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, MovieDatabase::class.java
        ).build()
        movieDao = db.getMovieDAO()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun movieDBTest() = runBlocking {

        val movie = Result("x", "x", "x", "x",
            "x", "x", "x", "x", "x")
        movieDao.upsert(movie)
        val movies = movieDao.getAllMovie()
        assertThat(movies.contains(movie)).isTrue()
    }
}
