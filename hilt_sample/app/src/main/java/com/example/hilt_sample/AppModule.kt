package com.example.hilt_sample

import android.app.Application
import androidx.room.Room
import com.example.hilt_sample.data.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePostDatabase(
        application:Application
    ) = Room.databaseBuilder(
        application,
        PostDatabase::class.java,
        "post_database"
    ).build()

    @Provides
    fun providePostDao(db: PostDatabase) = db.postDao()
}