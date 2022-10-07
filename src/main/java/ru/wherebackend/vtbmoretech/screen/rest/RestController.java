package ru.wherebackend.vtbmoretech.screen.rest;

import io.jmix.core.DataManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.entity.Employee;

import java.util.UUID;

@org.springframework.web.bind.annotation.RestController("vtbmt_RestController")
@RequestMapping("/front/get")
public class RestController {

    private DataManager dataManager;

    @RequestMapping(value = "/getInfoEmployee",method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam("userId") UUID userId) {
        return dataManager.load(Employee.class)
                .id(userId)
                .one();
    }
}
