package com.bankingmanagement.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class HealthService implements HealthIndicator {

    @Override
    public Health health() {
        if(getReportService()){
            return Health.up().withDetail("ReportService", "Report service up").build();
        }else{
            return Health.down().withDetail("ReportService", "Report service Down!!").build();
        }
    }
    public boolean getReportService() { return true; }
}
