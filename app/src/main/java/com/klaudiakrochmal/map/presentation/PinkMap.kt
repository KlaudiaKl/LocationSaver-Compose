package com.klaudiakrochmal.map.presentation

object PinkMap {
   val json ="""
        [
    {
        "featureType": "administrative",
        "elementType": "labels.text.fill",
        "stylers": [
        {
            "color": "#444444"
        }
        ]
    },
    {
        "featureType": "administrative.land_parcel",
        "elementType": "labels",
        "stylers": [
        {
            "color": "#000000"
        }
        ]
    },
    {
        "featureType": "administrative.land_parcel",
        "elementType": "labels.text",
        "stylers": [
        {
            "saturation": "0"
        }
        ]
    },
    {
        "featureType": "administrative.land_parcel",
        "elementType": "labels.text.fill",
        "stylers": [
        {
            "color": "#000000"
        }
        ]
    },
    {
        "featureType": "landscape",
        "elementType": "all",
        "stylers": [
        {
            "color": "#f2f2f2"
        }
        ]
    },
    {
        "featureType": "poi",
        "elementType": "all",
        "stylers": [
        {
            "visibility": "off"
        }
        ]
    },
    {
        "featureType": "road",
        "elementType": "all",
        "stylers": [
        {
            "saturation": -100
        },
        {
            "lightness": 45
        }
        ]
    },
    {
        "featureType": "road.highway",
        "elementType": "all",
        "stylers": [
        {
            "visibility": "simplified"
        },
        {
            "color": "#eb6aa4"
        },
        {
            "gamma": "3.5"
        },
        {
            "weight": "1"
        }
        ]
    },
    {
        "featureType": "road.highway",
        "elementType": "labels",
        "stylers": [
        {
            "visibility": "off"
        }
        ]
    },
    {
        "featureType": "road.highway",
        "elementType": "labels.text.stroke",
        "stylers": [
        {
            "visibility": "off"
        }
        ]
    },
    {
        "featureType": "road.highway",
        "elementType": "labels.icon",
        "stylers": [
        {
            "color": "#cbc7c7"
        },
        {
            "gamma": "2.00"
        }
        ]
    },
    {
        "featureType": "road.arterial",
        "elementType": "all",
        "stylers": [
        {
            "visibility": "simplified"
        }
        ]
    },
    {
        "featureType": "road.arterial",
        "elementType": "labels.icon",
        "stylers": [
        {
            "visibility": "off"
        }
        ]
    },
    {
        "featureType": "transit",
        "elementType": "all",
        "stylers": [
        {
            "visibility": "off"
        }
        ]
    },
    {
        "featureType": "water",
        "elementType": "all",
        "stylers": [
        {
            "color": "#eb6aa4"
        },
        {
            "visibility": "on"
        },
        {
            "saturation": "0"
        },
        {
            "lightness": "0"
        },
        {
            "gamma": "1"
        }
        ]
    }
    ]""".trimIndent()
}