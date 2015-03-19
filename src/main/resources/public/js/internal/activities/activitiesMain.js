(function(angular) {

	angular.module('activitiesMain',
			[ 'activitiesMain.controllers', 'activitiesMain.services' ])
			.filter('getDateFromRest', function() {

				return function(item) {

					return new Date(item);
				}
			});

})(angular);