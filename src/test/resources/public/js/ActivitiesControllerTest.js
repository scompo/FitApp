describe('Activities controller test', function() {

	beforeEach(module('activitiesMain.controllers'));
	beforeEach(module('activitiesMain.services'));

	var $controller;
	var $httpBackend;

	beforeEach(inject(function(_$controller_, _$httpBackend_) {

		$controller = _$controller_;
		$httpBackend = _$httpBackend_;
		$httpBackend.expectGET(/^\/api\/v1\/activities\?.*/).respond({
			totalPages : 1,
			content : []
		});
	}));

	describe('Controller new data', function() {

		var $scope, controller;

		beforeEach(function() {

			$scope = {};
			controller = $controller('activitiesController', {

				$scope : $scope
			});
		});

		it('should create a new instance to save', function() {
		
			expect($scope.newItem).not.toBe(null);
		});

		it('should create activities', function() {
			
			$httpBackend.flush();	
			expect($scope.activities).toEqual([]);
		});

		it('should get the number of pages', function() {
			
			$httpBackend.flush();
			expect($scope.totalPages).toBe(1);
		});
	});
});