package it.scompo.utils.test;

import static org.junit.Assert.assertEquals;
import it.scompo.FitApp.config.DateTimeUtils;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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
	public void testGetCurrentDateTime() {

		assertEquals(ZonedDateTime.now(testClock), dateTimeUtils.getCurrentDateTime());
	}
}
