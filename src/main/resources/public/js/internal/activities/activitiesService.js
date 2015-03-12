(function(angular) {

	var ActivitiesFactory = function($resource) {

		return $resource('/api/v1/activities', {}, {
			
			getPaginated : {
				method : 'GET'
			},
			save : {
				method : 'POST'
			}
		});
	};

	ActivitiesFactory.$inject = [ '$resource' ];

	angular.module('activitiesMain.services').factory('activitiesRestService',
			ActivitiesFactory);

}(angular));