package ru.wherebackend.vtbmoretech.screen.department;

import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.employee.Department;

@UiController("vtbmt_Department.browse")
@UiDescriptor("department-browse.xml")
@LookupComponent("departmentsTable")
public class DepartmentBrowse extends StandardLookup<Department> {
}