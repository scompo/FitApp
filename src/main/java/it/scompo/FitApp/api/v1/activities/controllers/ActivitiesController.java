package it.scompo.FitApp.api.v1.activities.controllers;

import it.scompo.FitApp.api.v1.activities.Activity;
import it.scompo.rest.CrudController;

public interface ActivitiesController extends CrudController<Activity, Long>{

	static final String URI = "/api/v1/activities";
	
	
}
