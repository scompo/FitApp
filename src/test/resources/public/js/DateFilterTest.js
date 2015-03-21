describe('DateFilter', function() {

	beforeEach(module('activitiesMain'));

	it('shoud create a date if populated', inject(function(
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