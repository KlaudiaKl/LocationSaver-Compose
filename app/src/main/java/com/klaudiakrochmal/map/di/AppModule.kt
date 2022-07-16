package com.klaudiakrochmal.map.di

import android.app.Application
import androidx.room.Room
import com.klaudiakrochmal.map.data.LocationDatabase
import com.klaudiakrochmal.map.data.LocationRepositoryImplementation
import com.klaudiakrochmal.map.domain.repository.LocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideLocationDatabase(app: Application): LocationDatabase{
        return Room.databaseBuilder(
            app,
            LocationDatabase::class.java,
            "locations.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideLocationsRepository(db: LocationDatabase): LocationRepository{
        return LocationRepositoryImplementation(db.dao)
    }
}