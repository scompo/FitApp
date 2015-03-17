describe('Activities controller test', function() {

	beforeEach(module('activitiesMain.controllers'));

	var $controller;

	beforeEach(inject(function(_$controller_) {

		$controller = _$controller_;
	}));

	describe('Controller new data', function() {

		var $scope, controller;

		beforeEach(function() {

			$scope = {};
			controller = $controller('activitiesController', {
				
				$scope : $scope,
				
				activitiesRestService : {
					getPaginated : function() {
						return {
							totalPages : 0,
							content : []
						};
					}
				}
			});
		});

		it('should create a new instance to save', function() {

			expect($scope.newItem).not.toBe(null);
		});

		it('should create activities', function() {

			expect($scope.activities).toEqual([]);
		});

		it('should get the number of pages', function() {

			expect($scope.totalPages).toBe(0);
		});
	});
});