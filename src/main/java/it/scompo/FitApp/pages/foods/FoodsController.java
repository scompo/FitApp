package it.scompo.FitApp.pages.foods;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/foods")
public class FoodsController {

	@RequestMapping
	public String index(){
		
		return "foods/index";
	}
}
