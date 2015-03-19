package it.scompo.utils.test;

import static org.junit.Assert.assertEquals;
import it.scompo.FitApp.config.DateTimeUtils;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DateTimeUtilsTest {

	Clock testClock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
	
	DateTimeUtils dateTimeUtils;

	@Before
	public void setUp() throws Exception {

		dateTimeUtils = new DateTimeUtils();
		dateTimeUtils.setClock(testClock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCurrentDate() {

		assertEquals(LocalDate.now(testClock), dateTimeUtils.getCurrentDate());
	}

	@Test
	public void testGetCurrentTime() {
		
		assertEquals(LocalTime.now(testClock), dateTimeUtils.getCurrentTime());
	}

}
