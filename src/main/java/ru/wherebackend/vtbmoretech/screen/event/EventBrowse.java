package ru.wherebackend.vtbmoretech.screen.event;

import io.jmix.ui.screen.*;
import ru.wherebackend.vtbmoretech.entity.Event;

@UiController("vtbmt_Event.browse")
@UiDescriptor("event-browse.xml")
@LookupComponent("eventsTable")
public class EventBrowse extends StandardLookup<Event> {
}