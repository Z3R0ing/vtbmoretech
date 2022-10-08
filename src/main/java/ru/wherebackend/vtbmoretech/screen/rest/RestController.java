package ru.wherebackend.vtbmoretech.screen.rest;

import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.entity.blog.News;
import ru.wherebackend.vtbmoretech.entity.employee.Employee;
import ru.wherebackend.vtbmoretech.entity.event.Event;

import java.util.List;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/get")
public class RestController {

//    @Autowired
//    private FetchPlans fetchPlans;
    @Autowired
    private DataManager dataManager;

    //Получение информации о пользователе
    @RequestMapping(value = "/getInfoEmployee",method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam("userId") UUID userId) {
//        FetchPlan fetchPlan = fetchPlans.builder(Employee.class)
//                .addFetchPlan(FetchPlan.BASE)
//                .add("user")
//                .build();

        return dataManager.load(Employee.class)
                .query("select e from vtbmt_Employee e where e.user.id = :userId")
                .parameter("userId", userId)
                .fetchPlan("for-employee")
                .one();
    }

    //Получение новостей
    @RequestMapping(value = "/getNews",method = RequestMethod.GET)
    public List<News> getNews() {
        return dataManager.load(News.class).all().list();
    }

    //Получение событий
    @RequestMapping(value = "/getEvent",method = RequestMethod.GET)
    public List<Event> getEvent() {
        return dataManager.load(Event.class).all().list();
    }
}
