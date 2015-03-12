(function(angular) {
	angular.module('activitiesMain.controllers', []);
	angular.module('activitiesMain.services', []);
	angular.module('activitiesMain', [ 'ngResource',
			'activitiesMain.controllers', 'activitiesMain.services' ]);
})(angular);