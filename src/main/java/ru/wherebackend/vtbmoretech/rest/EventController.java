package ru.wherebackend.vtbmoretech.rest;

import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.wherebackend.vtbmoretech.entity.employee.Employee;
import ru.wherebackend.vtbmoretech.entity.event.Event;
import ru.wherebackend.vtbmoretech.entity.event.NFT;
import ru.wherebackend.vtbmoretech.entity.event.Participant;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private CurrentAuthentication currentAuthentication;

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
        Participant participant = dataManager.create(Participant.class);
        Event event = dataManager.load(Event.class)
                .id(eventId)
                .fetchPlan("_base")
                .one();
        participant.setEvent(event);
        UserDetails user = currentAuthentication.getUser();
        Employee employee = dataManager.load(Employee.class)
                .query("select e from vtbmt_Employee e where e.user.username = :user")
                .parameter("user", user.getUsername())
                .fetchPlan("for-employee")
                .one();
        participant.setEmployee(employee);
        participant.setApproved(true);
        dataManager.save(participant);
        return participant;
    }

    @RequestMapping(value = "/approve",method = RequestMethod.POST)
    public Participant approve(@RequestParam("eventId") UUID eventId, @RequestParam("code") String code) {
        Participant participant = dataManager.load(Participant.class)
                .query("select e from vtbmt_Participant where e.event.id = :eventId")
                .parameter("eventId", eventId)
                .fetchPlan("_base")
                .one();
        participant.setApproved(true);
        Event event = dataManager.load(Event.class)
                .query("select e from vtbmt_Event e whete e.code = :code")
                .parameter("code", code)
                .fetchPlan("_base")
                .optional()
                .orElse(null);
        if (event != null) {
            List<NFT> nft = dataManager.load(NFT.class)
                    .query("select e from vtbmt_NFT e where e.dateOfReceiving is null")
                    .fetchPlan("_base")
                    .list();
            Random rand = new Random();
            NFT randomNft = nft.get(rand.nextInt(nft.size()));
            randomNft.setDateOfReceiving(new Date());
            randomNft.setOwner(participant.getEmployee());
            dataManager.save(randomNft);
        } else {
            System.out.println("Code not working");
        }
        return dataManager.save(participant);
    }
}
