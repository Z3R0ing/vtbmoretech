package ru.wherebackend.vtbmoretech.screen.department;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.employee.Department;

@UiController("vtbmt_Department.edit")
@UiDescriptor("department-edit.xml")
@EditedEntityContainer("departmentDc")
public class DepartmentEdit extends StandardEditor<Department> {
}