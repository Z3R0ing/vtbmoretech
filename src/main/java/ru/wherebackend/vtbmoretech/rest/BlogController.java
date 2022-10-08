package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.entity.blog.News;
import ru.wherebackend.vtbmoretech.entity.employee.Employee;
import ru.wherebackend.vtbmoretech.rest.dtos.NewsDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private CurrentAuthentication currentAuthentication;

    //Получение новостей
    @RequestMapping(value = "/getNews",method = RequestMethod.GET)
    public List<News> getNews() {
        return dataManager.load(News.class).all().fetchPlan("_base").list();
    }

    @RequestMapping(value = "/getOneNews",method = RequestMethod.GET)
    public News getOneNews(@RequestParam("newsId") UUID newsId) {
        return dataManager.load(News.class).all().fetchPlan("_base").optional().orElse(null);
    }

    @RequestMapping(value = "/addNews",method = RequestMethod.POST)
    public News addNews(@RequestBody NewsDTO news) {
        News news1 = dataManager.create(News.class);
        news1.setTopic(news.getName());
        news1.setDescription(news.getText());
        news1.setDatePublication(new Date());
        UserDetails user = currentAuthentication.getUser();
        Employee employee = dataManager.load(Employee.class)
                .query("select e from vtbmt_Employee e where e.user.username = :user")
                .parameter("user", user.getUsername())
                .fetchPlan("for-employee")
                .one();
        news1.setEmployee(employee);
        dataManager.save(news1);
        return news1;
    }

}
