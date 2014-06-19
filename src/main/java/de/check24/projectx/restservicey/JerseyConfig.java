package de.check24.projectx.restservicey;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * @author Tomas Skalicky
 *         <p>
 *         Created on 20.05.2014
 *         </p>
 *         <p>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(RequestContextFilter.class);
		packages(getThisClassPackageName());
		register(LoggingFilter.class);
		property(ServerProperties.JSON_PROCESSING_FEATURE_DISABLE, false);
	}

	private String getThisClassPackageName() {
		return getClass().getPackage().getName();
	}
}
