/* eslint-disable linebreak-style */
/* eslint-disable indent */
/* eslint-disable max-len */

const mapService = require('../services/mapService');
const mapConfig = require('../config/mapConfig');

let map;
let userLocation;

/**
 * Initializes the map by getting the user's location and displaying nearby places.
 */
function initMap() {
  navigator.geolocation.getCurrentPosition(
    /**
     * Success callback for retrieving the user's location.
     * @param {Position} position - The user's position.
     */
    (position) => {
      userLocation = {
        lat: position.coords.latitude,
        lng: position.coords.longitude,
      };

      map = new google.maps.Map(document.getElementById('map'), {
        center: userLocation,
        zoom: mapConfig.defaultZoomLevel,
      });

      // Call a function to fetch and display nearby places
      getNearbyPlaces('Toko Batik');
    },
    /**
     * Error callback for retrieving the user's location.
     * @param {PositionError} error - The error object.
     */
    (error) => {
      console.error('Error getting user location:', error);
      // Handle the error, for example, by showing a default location on the map
      map = new google.maps.Map(document.getElementById('map'), {
        center: mapConfig.defaultLocation,
        zoom: mapConfig.defaultZoomLevel,
      });
    },
  );
}

/**
 * Fetches nearby places based on a keyword and displays them on the map.
 * @param {string} keyword - The keyword to search for nearby places.
 */
function getNearbyPlaces(keyword) {
    mapService.getNearbyPlacesService(userLocation, keyword)
    .then((result) => {
        for (let i = 0; i < result.length; i++) {
        createMarker(result[i]);
        }
    })
    .catch((error) => {
      console.error('Error fetching nearby places:', error);
      // Handle the error, possibly by showing a user-friendly message to the user
    });
}

/**
 * Creates a marker on the map for a given place and sets up an info window.
 * @param {Object} place - The place object from the Places API.
 */
function createMarker(place) {
    const marker = new google.maps.Marker({
        map: map,
        position: place.geometry.location,
        title: place.name,
    });

    marker.addListener('click', () => {
        const infowindow = new google.maps.InfoWindow();
        infowindow.setContent(place.name);
        infowindow.open(map, marker);
    });
}

// Export the functions to be used in app.js or other parts of the application
module.exports = {
  initMap,
};
