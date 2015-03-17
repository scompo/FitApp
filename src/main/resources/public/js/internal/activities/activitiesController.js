(function(angular) {

	angular.module('activitiesMain.controllers', []).controller(
			'activitiesController',
			[
					'$scope',
					'activitiesRestService',
					function($scope, activitiesRestService) {

						$scope.page = 0;
						$scope.size = 5;
						$scope.totalPages = 0;

						$scope.newItem = {};

						getData();

						function getData() {

							activitiesRestService.getPaginated({

								page : $scope.page,
								size : $scope.size

							}, function(data) {

								$scope.activities = data.content;
								$scope.totalPages = data.totalPages;
							});
						}
						;

						$scope.save = function() {

							activitiesRestService.save($scope.newItem,
									function() {
										getData();
									});
						};

						$scope.next = function() {

							if ($scope.page < $scope.totalPages - 1) {

								$scope.page++;
							}
							getData();
						};

						$scope.prev = function() {

							if ($scope.page > 0) {

								$scope.page--;
							}
							getData();
						};

					} ]);

}(angular));