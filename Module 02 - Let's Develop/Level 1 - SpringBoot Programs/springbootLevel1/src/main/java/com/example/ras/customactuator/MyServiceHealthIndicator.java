package com.example.ras.customactuator;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyServiceHealthIndicator implements HealthIndicator  {

	@Override
	public @Nullable Health health() {
		boolean serviceRunningFine = checkServiceStatus();
		 if (serviceRunningFine) {
	            return Health.up().withDetail("myService", "Working Fine").build();
	        }
	        return Health.down().withDetail("myService", "Service Failed!").build();
	    }

	
	
	private boolean checkServiceStatus() {
        return true; // yaha real check hota hai
    }

}
