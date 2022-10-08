package ru.wherebackend.vtbmoretech.screen.thing;

import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.market.Thing;

@UiController("vtbmt_Thing.browse")
@UiDescriptor("thing-browse.xml")
@LookupComponent("thingsTable")
public class ThingBrowse extends StandardLookup<Thing> {
}