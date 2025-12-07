package com.example.ras.eventandlistener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.ras.entity.Employee;

@Component
public class EmployeeAddedListener {

    @EventListener
    public void handleEmployeeAdded(EmployeeAddedEvent event) {
        Employee employee = event.getEmployee();
        System.out.println("🎉 Employee Added: " + employee.getName() + ", Email: " + employee.getEmail());

        // Yaha kuch extra kaam kar sakte ho:
        // - Email bhejna
        // - Audit log
        // - Notification system trigger
    }
}

