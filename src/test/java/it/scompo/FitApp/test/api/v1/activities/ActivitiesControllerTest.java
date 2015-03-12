package it.scompo.FitApp.test.api.v1.activities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import it.scompo.FitApp.Application;
import it.scompo.FitApp.api.v1.activities.ActivitiesController;
import it.scompo.FitApp.api.v1.activities.ActivitiesService;
import it.scompo.FitApp.api.v1.activities.Activity;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest
@SpringApplicationConfiguration(classes = { Application.class })
public class ActivitiesControllerTest {

	protected static final String TEST_NAME = "blah";

	private static final Activity ACTIVITY_TO_SAVE = new Activity(TEST_NAME);

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private ObjectMapper jsonMapper;

	private MockMvc mockMvc;

	@Autowired
	private ActivitiesService activitiesService;

	@Before
	public void setUp() throws Exception {

		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetById() throws Exception {

		Activity saved = activitiesService.save(ACTIVITY_TO_SAVE);

		MvcResult res = mockMvc
				.perform(get(ActivitiesController.URI + "/" + saved.getId()))
				.andExpect(status().isOk()).andReturn();

		Activity returned = getObjectFromString(jsonMapper, res.getResponse()
				.getContentAsString(), Activity.class);

		assertEquals(saved, returned);
	}

	@Test
	public void testSave() throws Exception {

		MvcResult res = null;
		res = mockMvc
				.perform(
						post(ActivitiesController.URI)
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
								.content(
										getStringFromObject(jsonMapper,
												ACTIVITY_TO_SAVE)))
				.andExpect(status().isOk()).andReturn();

		Activity resActivity = getObjectFromString(jsonMapper, res
				.getResponse().getContentAsString(), Activity.class);

		assertNotNull(resActivity);
		assertNotNull(resActivity.getId());
		assertEquals(ACTIVITY_TO_SAVE.getName(), resActivity.getName());

		Activity resDb = activitiesService.getById(resActivity.getId());

		assertEquals(resDb, resActivity);
	}

	private <T> T getObjectFromString(ObjectMapper objectMapper, String obj,
			Class<T> class1) throws JsonParseException, JsonMappingException,
			IOException {

		return objectMapper.readValue(obj, class1);
	}

	private <T> String getStringFromObject(ObjectMapper objectMapper, T obj)
			throws JsonProcessingException {

		return objectMapper.writeValueAsString(obj);
	}

}
