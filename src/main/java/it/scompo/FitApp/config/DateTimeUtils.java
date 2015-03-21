package it.scompo.FitApp.config;

import java.time.Clock;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DateTimeUtils {

	@Autowired
	private Clock applicationClock;

	public Clock getClock() {
		return applicationClock;
	}

	public void setClock(Clock clock) {

		this.applicationClock = clock;
	}

	public ZonedDateTime getCurrentDateTime() {

		return ZonedDateTime.now(getClock());
	}
}
