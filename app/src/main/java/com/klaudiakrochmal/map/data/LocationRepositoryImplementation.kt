package com.klaudiakrochmal.map.data

import com.klaudiakrochmal.map.domain.model.Location
import com.klaudiakrochmal.map.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocationRepositoryImplementation(
    private val dao: LocationDao
): LocationRepository {
    override suspend fun insertLocation(location: Location) {
        dao.insertLocation(location = location.toLocationEntity())
    }

    override suspend fun deleteLocation(location: Location) {
        dao.deleteLocation(location.toLocationEntity())
    }

    override fun getLocations(): Flow<List<Location>> {
        return dao.getLocations().map { locations ->
            locations.map{
                it.toLocation()
            }
        }
        //must be mapped twice because 1. it's a flow, 2. it's a list
    }

}