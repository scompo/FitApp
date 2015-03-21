package it.scompo.FitApp.config;

import java.time.Clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationClockConfiguration {

	/**
	 * Application clock configuration.
	 * 
	 * @return the application {@link Clock}.
	 */
	@Bean
	public Clock getApplicationClock() {

		return Clock.systemUTC();
	}
}
