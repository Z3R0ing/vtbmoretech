package ru.wherebackend.vtbmoretech.screen.thing;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.market.Thing;

@UiController("vtbmt_Thing.edit")
@UiDescriptor("thing-edit.xml")
@EditedEntityContainer("thingDc")
public class ThingEdit extends StandardEditor<Thing> {
}