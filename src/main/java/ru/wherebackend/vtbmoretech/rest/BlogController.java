package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.wherebackend.vtbmoretech.entity.blog.News;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private DataManager dataManager;

    //Получение новостей
    @RequestMapping(value = "/getNews",method = RequestMethod.GET)
    public List<News> getNews() {
        return dataManager.load(News.class).all().list();
    }

}
