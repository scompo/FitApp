package it.scompo.FitApp.api.v1.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ActivitiesController.URI)
public class ActivitiesCrudController implements ActivitiesController {

	@Autowired
	private ActivitiesService activitiesService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Activity> getPaginated(Pageable pageable) {

		return activitiesService.getPaginated(pageable);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Activity save(@RequestBody Activity activity){
		
		return activitiesService.save(activity);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public Activity getById(@PathVariable Long id){
		
		return activitiesService.getById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Activity update(@PathVariable Long id, @RequestBody Activity entity){
		
		return activitiesService.update(id, entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id){
		
		activitiesService.delete(id);
	}
}
