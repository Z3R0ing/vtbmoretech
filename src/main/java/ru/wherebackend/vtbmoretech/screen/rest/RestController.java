package ru.wherebackend.vtbmoretech.screen.rest;

import io.jmix.core.DataManager;
import io.jmix.core.FluentLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.entity.Employee;
import ru.wherebackend.vtbmoretech.entity.News;

import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/get")
public class RestController {

    private DataManager dataManager;

    @RequestMapping(value = "/getInfoEmployee",method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam("userId") UUID userId) {
        return dataManager.load(Employee.class)
                .query("select e from vtbmt_Employee e where e.user.id = :userId")
                .parameter("userId", userId)
                .one();
    }

    @RequestMapping(value = "/getNews",method = RequestMethod.GET)
    public FluentLoader.ByCondition<News> getNews() {
        return dataManager.load(News.class).all();
    }
}
