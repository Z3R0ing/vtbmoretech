package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.entity.blog.News;
import ru.wherebackend.vtbmoretech.rest.dtos.NewsDTO;

import java.util.List;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private DataManager dataManager;

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
        // TODO
        throw new RuntimeException("Not yet");
    }

}
