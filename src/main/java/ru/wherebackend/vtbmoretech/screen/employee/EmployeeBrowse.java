package ru.wherebackend.vtbmoretech.screen.employee;

import io.jmix.ui.screen.*;
import ru.wherebackend.vtbmoretech.entity.Employee;

@UiController("vtbmt_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
public class EmployeeBrowse extends StandardLookup<Employee> {
}