package ru.wherebackend.vtbmoretech.screen.achviement;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.event.Achviement;

@UiController("vtbmt_Achviement.edit")
@UiDescriptor("achviement-edit.xml")
@EditedEntityContainer("achviementDc")
public class AchviementEdit extends StandardEditor<Achviement> {
}