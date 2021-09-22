package com.example.hilt_sample.di

import android.content.Context
import androidx.room.Room
import com.example.hilt_sample.data.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PostDatabase::class.java,
        "post_database"
    ).build()

    @Provides
    fun providePostdao(db: PostDatabase) = db.postDao()

}