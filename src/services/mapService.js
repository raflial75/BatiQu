/* eslint-disable linebreak-style */
/* eslint-disable indent */
/* eslint-disable max-len */

/**
 * Map Service Class
 */
class MapService {
    /**
    * @param {Object} userLocation - User location coordinates
    * @param {string} keyword - Keywor for locating nearby places
    * @return {Promise<Array>} - A promise that resolves to an array of nearby places.
    * @throws {Error} If the places service request fails
    */
    async getNearbyPlacesService(userLocation, keyword) {
        return new Promise((resolve, reject) => {
            const request = {
                location: userLocation,
                radius: 1000,
                keyword: keyword,
                rankBy: google.maps.places.RankBy.PROMINENCE,
            };
            const placesService = new google.maps.places.PlacesService(map);
            placesService.nearbySearch(request, (result, status) => {
                if (status === google.maps.places.PlacesServiceStatus.OK) {
                    result.sort((a, b) => (b.rating || 0) - (a.rating || 0));
                    resolve(result);
                } else {
                    reject(new Error(`Places service request failed with status: ${status}`));
                }
            });
        });
    };
};

module.exports = new MapService();
