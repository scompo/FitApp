describe('DateFilter', function() {

	beforeEach(module('activitiesMain'));

	it('shoud not return an empty string if the date is correct', inject(function(
			getDateFromRestFilter) {
		
		var date = '2015-03-21T15:13:01.003';

		expect(getDateFromRestFilter(date)).not.toEqual('');
	}));
	
	it('shoud return the correct date', inject(function(
			getDateFromRestFilter) {
		
		var date = '2015-03-21T15:13:01.003';

		expect(getDateFromRestFilter(date)).toEqual('21/03/2015 15:13');
	}));

	it('shoud return empty string if date is undefined', inject(function(
			getDateFromRestFilter) {

		expect(getDateFromRestFilter(undefined)).toEqual('');
	}));
	
	it('shoud return empty string if date is null', inject(function(
			getDateFromRestFilter) {

		expect(getDateFromRestFilter(null)).toEqual('');
	}));
	
})