package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.entity.event.Event;
import ru.wherebackend.vtbmoretech.entity.event.Participant;

import java.util.List;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private DataManager dataManager;

    //Получение событий
    @RequestMapping(value = "/getEvents",method = RequestMethod.GET)
    public List<Event> getEvents() {
        return dataManager.load(Event.class).all().fetchPlan("_base").list();
    }

    //Получение события
    @RequestMapping(value = "/getEvent",method = RequestMethod.GET)
    public Event getEvent(@RequestParam("eventId") UUID eventId) {
        return dataManager.load(Event.class).id(eventId).fetchPlan("_base").optional().orElse(null);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Participant register(@RequestParam("eventId") UUID eventId) {
        // TODO
        throw new RuntimeException("Not yet");
    }

    @RequestMapping(value = "/approve",method = RequestMethod.POST)
    public Participant approve(@RequestParam("eventId") UUID eventId, @RequestParam("eventId") String code) {
        // TODO поставить у Participant approved = true
        throw new RuntimeException("Not yet");
    }
}
