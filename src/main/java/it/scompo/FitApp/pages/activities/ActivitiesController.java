package it.scompo.FitApp.pages.activities;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/activities")
public class ActivitiesController {

	@RequestMapping
	public String index() {

		return "activities/index";
	}
}
