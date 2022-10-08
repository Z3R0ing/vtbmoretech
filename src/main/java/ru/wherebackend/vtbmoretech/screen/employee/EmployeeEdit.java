package ru.wherebackend.vtbmoretech.screen.employee;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.employee.Employee;

@UiController("vtbmt_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
public class EmployeeEdit extends StandardEditor<Employee> {
}