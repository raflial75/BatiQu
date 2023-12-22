/**
 * @function initMap
 */

function initMap() {
    // Create google map
    const map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: -34.397, lng: 150.644 }, // Default location (Sydney, Australia)
        zoom: 15,
    });

    // Create a new geocoder
    const geocoder = new google.maps.Geocoder();

    // Get real-time location
    if (navigator.geolocation) {
        // Use watchPosition for continuous tracking
        const watchId = navigator.geolocation.watchPosition(
            (position) => {
                // Set map center to user location
                map.setCenter({
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                });

                // Clear existing markers or do any other real-time updates

                // Find nearby restaurants
                const service = new google.maps.places.PlacesService(map);
                service.nearbySearch({
                    location: {
                        lat: position.coords.latitude,
                        lng: position.coords.longitude
                    },
                    radius: 1000,
                    keyword: ['Toko Batik', 'Butik'],
                }, (result, status) => {
                    if (status === google.maps.places.PlacesServiceStatus.OK) {
                        result.forEach((tokoBatik) => {
                            // Create marker
                            const tokoBatiMarker = new google.maps.Marker({
                                position: tokoBatik.geometry.location,
                                map,
                            });

                            // Get distance and time to the toko batik
                            const getDirection = new google.maps.DirectionsService();
                            const directionRenderer = new google.maps.DirectionsRenderer();

                            getDirection.route({
                                origin: {
                                    lat: position.coords.latitude,
                                    lng: position.coords.longitude,
                                },
                                destination: tokoBatik.geometry.location,
                                travelMode: google.maps.TravelMode.WALKING,
                            }, (response, status) => {
                                if (status === google.maps.DirectionsStatus.OK) {
                                    // Display the route on the map
                                    directionRenderer.setDirections(response);
                                    // directionRenderer.setMap(map);

                                    // Show distance and time on the marker info window
                                    tokoBatiMarker.infoWindow = new google.maps.InfoWindow({
                                        content: `<b>${tokoBatik.name}</b><br>${tokoBatik.vicinity}<br>`,
                                    });

                                    tokoBatiMarker.addListener('click', () => {
                                        tokoBatiMarker.infoWindow.open(map, tokoBatiMarker);
                                    });
                                }
                            });
                        });
                    }
                });
            },
            (error) => {
                console.error('Error getting the user location:', error);
            },
            {
                enableHighAccuracy: true, // Use high accuracy for better location tracking
            }
        );

        // Optionally, you can store the watchId if you want to clear the watch later
        // For example, navigator.geolocation.clearWatch(watchId);
    } else {
        console.error('Geolocation is not supported by this browser.');
    }
}
