(function(angular) {

	var ActivitiesController = function($scope, activitiesRestService) {

		$scope.newItem = {};

		getResources();

		function getResources() {

			activitiesRestService
					.getPaginated(function(resource) {
						console.log(resource);
						$scope.activities = resource.content;
					});
		}

		$scope.save = function() {

			activitiesRestService.save($scope.newItem);
			getResources();
		};

	};

	ActivitiesController.$inject = [ '$scope', 'activitiesRestService' ];

	angular.module('activitiesMain.controllers').controller(
			'activitiesController', ActivitiesController);

}(angular));