(function(angular) {

	angular.module('activitiesMain.controllers', [ 'ui.bootstrap' ])
			.controller(
					'activitiesController',
					[
							'$scope',
							'activitiesRestService',
							function($scope, activitiesRestService) {

								$scope.page = 1;
								$scope.size = 5;
								$scope.totalPages = 0;
								$scope.totalItems = 0;

								$scope.newItem = {};

								getData();

								function getData() {
									console.log($scope.page);
									console.log($scope.size);
									activitiesRestService.getPaginated({

										page : $scope.page - 1,
										size : $scope.size

									}, function(data) {

										$scope.activities = data.content;
										$scope.totalPages = data.totalPages;
										$scope.totalItems = data.totalElements;
										console.log($scope.totalPages);
										console.log($scope.totalItems);
									});
								}
								;

								$scope.save = function() {

									activitiesRestService.save($scope.newItem,
											function() {
												getData();
											});
								};

								$scope.paginate = function() {

									getData();
								};
							} ]);

}(angular));