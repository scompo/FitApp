package it.scompo.FitApp.api.v1.activities;

import it.scompo.FitApp.config.DateTimeUtils;
import it.scompo.rest.AbstractCrudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActivitiesCrudService extends AbstractCrudService<Activity, Long>
		implements ActivitiesService {
	
	@Autowired
	private DateTimeUtils dateTimeUtils;

	@Override
	public void updateObject(Activity entity, Activity dao) {

		dao.setName(entity.getName());
	}

	@Override
	@Autowired
	@Qualifier(value = "activitiesRepository")
	public void setRepository(
			PagingAndSortingRepository<Activity, Long> repository) {
		
		super.setRepository(repository);
	}

	@Override
	public Activity save(Activity entity) {
		
		if(entity.getDate() == null){
			
			entity.setDate(dateTimeUtils.getCurrentDate());
		}
		
		if(entity.getTime() == null){
			
			entity.setTime(dateTimeUtils.getCurrentTime());
		}
		
		return super.save(entity);
	}

	

}
