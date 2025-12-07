package com.example.ras.eventandlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import com.example.ras.entity.Employee;

public class EmployeeAddedEvent extends ApplicationEvent {

    private Employee employee;

    public EmployeeAddedEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
