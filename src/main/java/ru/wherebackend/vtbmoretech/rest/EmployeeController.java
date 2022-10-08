package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.entity.employee.Employee;

import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private DataManager dataManager;

    //Получение информации о пользователе
    @RequestMapping(value = "/getInfoEmployee",method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam("userId") UUID userId) {
        return dataManager.load(Employee.class)
                .query("select e from vtbmt_Employee e where e.user.id = :userId")
                .parameter("userId", userId)
                .fetchPlan("for-employee")
                .one();
    }

}
