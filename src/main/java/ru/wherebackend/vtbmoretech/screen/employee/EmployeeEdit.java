package ru.wherebackend.vtbmoretech.screen.employee;

import io.jmix.ui.screen.*;
import ru.wherebackend.vtbmoretech.entity.Employee;

@UiController("vtbmt_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
public class EmployeeEdit extends StandardEditor<Employee> {
}