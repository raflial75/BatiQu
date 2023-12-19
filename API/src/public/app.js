/**
 * @function initMap
 */

let userLocation

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
        navigator.geolocation.getCurrentPosition(
            (position) => {
            // Set map center to user location
            map.setCenter({
                lat: position.coords.latitude,
                lng: position.coords.longitude
            })

            // Find nearby restaurants
            const service = new google.maps.places.PlacesService(map);
            service.nearbySearch({
                location: {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                },
                radius: 500,
                type: 'Toko Batik',
            }, (result, status) => {
                if (status === google.maps.places.PlacesServiceStatus.OK) {
                    result.forEach((tokoBatik) => {
                        // Create marker
                        const tokoBatiMarker = new google.maps.Marker({
                            position: tokoBatik.geometry.location,
                            map,
                        });

                        // Get distance and time to the toko batik
                        const getDirection = new google.maps.DirectionServices();
                        getDirection.route({
                            origin: {
                                lat: position.coords.latitude,
                                lng: position.coords.longitude,
                            },
                            destination: tokoBatik.geometry.location.DirectionsService,
                            travelMode: google.maps.TravelMode.WALKING,
                        }, (response, status) => {
                            if (status === google.maps.DirectionsServiceStatus.OK) {
                                const distance = response.routes[0].legs[0].distance.value;
                                const time = response.routes[0].legs[0].duration.value;
                                const distanceText = `${distance / 1000} km`; // convert meters to km
                                const timeText = `${Math.floor(time / 60)} min`; // convert seconds to minutes
                
                                // Show distance and time on the marker info window
                                tokoBatiMarker.infoWindow = new google.maps.InfoWindow({
                                  content: `<b>${tokoBatik.name}</b><br>${tokoBatik.vicinity}<br>Distance: ${distanceText}<br>Time: ${timeText}`,
                                });
                
                                tokoBatiMarker.addListener('click', () => {
                                  tokoBatiMarker.infoWindow.open(map, tokoBatiMarker);
                                });
                            }
                        })
                    });
                }
            })
        })
    }
}
