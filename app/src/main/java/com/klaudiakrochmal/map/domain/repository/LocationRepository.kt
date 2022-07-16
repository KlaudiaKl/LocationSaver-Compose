package com.klaudiakrochmal.map.domain.repository

import com.klaudiakrochmal.map.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    suspend fun insertLocation(location: Location)
    suspend fun deleteLocation(location: Location)
    fun getLocations(): Flow<List<Location>>
}