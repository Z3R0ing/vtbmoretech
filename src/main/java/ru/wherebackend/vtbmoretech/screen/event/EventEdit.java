package ru.wherebackend.vtbmoretech.screen.event;

import io.jmix.ui.screen.*;
import ru.wherebackend.vtbmoretech.entity.Event;

@UiController("vtbmt_Event.edit")
@UiDescriptor("event-edit.xml")
@EditedEntityContainer("eventDc")
public class EventEdit extends StandardEditor<Event> {
}