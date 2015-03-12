package it.scompo.FitApp;

import java.net.URI;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RestRepositoryConfiguration extends RepositoryRestMvcConfiguration {

	private static final String API_V1_BASE_URL = "/api/v1";

	@Override
	protected void configureRepositoryRestConfiguration(
			RepositoryRestConfiguration config) {

		super.configureRepositoryRestConfiguration(config);
		config.setBaseUri(URI.create(API_V1_BASE_URL));
	}
}
