package com.example.hilt_sample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Post::class], version = 1)
abstract class PostDatabase: RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        private var instance:PostDatabase? = null
        fun getInstance(context: Context):PostDatabase {
            return instance ?: Room.databaseBuilder(
                context,
                PostDatabase::class.java,
                "post_database"
            ).build()
        }
    }

}