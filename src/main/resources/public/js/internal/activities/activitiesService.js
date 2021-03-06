(function(angular) {

	angular.module('activitiesMain.services', [ 'ngResource' ]).factory(

	'activitiesRestService', [ '$resource', function($resource) {

		return $resource('/api/v1/activities/:id', {}, {

			getPaginated : {

				method : 'GET'
			},

			save : {

				method : 'POST'
			}
		});
	} ]);

}(angular));