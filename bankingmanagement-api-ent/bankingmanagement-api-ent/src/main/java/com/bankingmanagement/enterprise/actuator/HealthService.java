package com.bankingmanagement.enterprise.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class HealthService implements HealthIndicator {
    @Override
    public Health health() {
        if(getReportService()){
            return Health.up().withDetail("Report service", "Report service up").build();
        }else{
            return Health.down().withDetail("ReportService", "Report service Down!!").build();
        }

    }

    public boolean getReportService() { return true; }
}
