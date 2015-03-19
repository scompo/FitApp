package it.scompo.FitApp.test.api.v1.activities;

import static it.scompo.FitApp.test.api.v1.activities.ActivitiesConstants.ACTIVITY_TO_SAVE_NO_DATE;
import static org.junit.Assert.*;
import it.scompo.FitApp.Application;
import it.scompo.FitApp.api.v1.activities.ActivitiesRepository;
import it.scompo.FitApp.api.v1.activities.ActivitiesService;
import it.scompo.FitApp.api.v1.activities.Activity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
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
	}

	@Test
	public void testGetById() {

		Activity activitySaved = activitiesRepository
				.save(ACTIVITY_TO_SAVE_NO_DATE);

		Activity res = activitiesService.getById(activitySaved.getId());

		assertEquals(activitySaved, res);
	}

	@Test
	public void testGetPaginated() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveNoDate() {

		Activity res = activitiesService.save(ACTIVITY_TO_SAVE_NO_DATE);

		assertNotNull(res);
		assertNotNull(res.getId());
		assertNotNull(res.getDate());
		assertNotNull(res.getTime());
		assertEquals(ACTIVITY_TO_SAVE_NO_DATE.getName(), res.getName());
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
