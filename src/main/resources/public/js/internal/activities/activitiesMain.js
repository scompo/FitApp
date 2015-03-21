(function(angular) {

	angular.module('activitiesMain',
			[ 'activitiesMain.controllers', 'activitiesMain.services' ])
			.filter('getDateFromRest', function($filter) {

				return function(item) {
					
					var angularDateFilter = $filter('date');

					var result = '';

					if (item != undefined) {

						result = angularDateFilter(item, 'dd/MM/yyyy HH:mm');
					}

					return result;
				}
			});

})(angular);