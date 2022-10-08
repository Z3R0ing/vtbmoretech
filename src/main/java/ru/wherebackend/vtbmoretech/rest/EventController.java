package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.wherebackend.vtbmoretech.entity.event.Event;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private DataManager dataManager;

    //Получение событий
    @RequestMapping(value = "/getEvent",method = RequestMethod.GET)
    public List<Event> getEvent() {
        return dataManager.load(Event.class).all().list();
    }

}
