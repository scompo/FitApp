package it.scompo.FitApp.test.api.v1.activities;

import static it.scompo.FitApp.test.api.v1.activities.ActivitiesConstants.ACTIVITIES_TO_PAGE;
import static it.scompo.FitApp.test.api.v1.activities.ActivitiesConstants.ACTIVITY_TO_SAVE_COMPLETE;
import static it.scompo.FitApp.test.api.v1.activities.ActivitiesConstants.ACTIVITY_TO_SAVE_NO_DATE;
import static it.scompo.FitApp.test.api.v1.activities.ActivitiesConstants.NUM_TO_CREATE_PAGINATED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import it.scompo.FitApp.Application;
import it.scompo.FitApp.api.v1.activities.Activity;
import it.scompo.FitApp.api.v1.activities.repositories.ActivitiesRepository;
import it.scompo.FitApp.api.v1.activities.services.ActivitiesService;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
@SpringApplicationConfiguration(classes = { Application.class })
public class ActivitiesCrudServiceTest {

	@Autowired
	private ActivitiesService activitiesService;

	@Autowired
	private ActivitiesRepository activitiesRepository;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

		activitiesRepository.deleteAll();
	}

	@Test
	public void testGetById() {

		Activity activitySaved = activitiesRepository
				.save(ACTIVITY_TO_SAVE_COMPLETE);

		Activity res = activitiesService.getById(activitySaved.getId());

		assertEquals(activitySaved, res);
	}

	@Test
	public void testGetPaginated() {

		activitiesRepository.save(ACTIVITIES_TO_PAGE);

		Page<Activity> res = activitiesService.getPaginated(new PageRequest(0,
				10));

		assertNotNull(res);
		assertEquals(NUM_TO_CREATE_PAGINATED, res.getTotalElements());
		assertEquals(10, res.getContent().size());
	}

	@Test
	public void testSave() {

		Activity res = activitiesService.save(ACTIVITY_TO_SAVE_COMPLETE);

		assertNotNull(res);
		assertNotNull(res.getId());
		assertEquals(ACTIVITY_TO_SAVE_COMPLETE.getStartTime(), res.getStartTime());
		assertEquals(ACTIVITY_TO_SAVE_COMPLETE.getEndTime(), res.getEndTime());
		assertEquals(ACTIVITY_TO_SAVE_COMPLETE.getName(), res.getName());
		
	}

	@Test
	public void testSaveNoDate() {

		Activity res = activitiesService.save(ACTIVITY_TO_SAVE_NO_DATE);

		assertNotNull(res);
		assertNotNull(res.getId());
		assertNotNull(res.getStartTime());
		assertNull(res.getEndTime());
		assertEquals(ACTIVITY_TO_SAVE_NO_DATE.getName(), res.getName());
	}

	@Test
	@Ignore("not used")
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {

		Activity activitySaved = activitiesRepository
				.save(ACTIVITY_TO_SAVE_COMPLETE);

		Long idDeleted = activitySaved.getId();

		activitiesService.delete(idDeleted);

		assertFalse(activitiesRepository.exists(idDeleted));
	}

}
