package it.scompo.FitApp.config;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DateTimeUtils {

	@Autowired
	private Clock applicationClock;

	/**
	 * Gets the current {@link LocalDate}.
	 * 
	 * @return the current {@link LocalDate}.
	 */
	public LocalDate getCurrentDate() {

		LocalDate currentDate = null;

		currentDate = LocalDate.now(applicationClock);

		return currentDate;
	}

	/**
	 * Gets the current {@link LocalTime}.
	 * 
	 * @return the current {@link LocalTime}.
	 */
	public LocalTime getCurrentTime() {

		LocalTime currentTime = null;

		currentTime = LocalTime.now(applicationClock);

		return currentTime;
	}

	public Clock getClock() {
		return applicationClock;
	}

	public void setClock(Clock clock) {
		
		this.applicationClock = clock;
	}
}
