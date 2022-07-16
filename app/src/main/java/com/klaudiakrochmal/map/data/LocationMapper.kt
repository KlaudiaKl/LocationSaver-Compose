package com.klaudiakrochmal.map.data

import com.klaudiakrochmal.map.domain.model.Location

fun LocationEntity.toLocation(): Location{
    return Location(
        lat = lat,
        lng = lng,
        id= id
    )
}

fun Location.toLocationEntity(): LocationEntity{
    return LocationEntity(
        lat = lat,
        lng = lng,
        id = id
    )
}