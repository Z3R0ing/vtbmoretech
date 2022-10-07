package ru.wherebackend.vtbmoretech.screen.achviement;

import io.jmix.ui.screen.*;
import ru.wherebackend.vtbmoretech.entity.Achviement;

@UiController("vtbmt_Achviement.edit")
@UiDescriptor("achviement-edit.xml")
@EditedEntityContainer("achviementDc")
public class AchviementEdit extends StandardEditor<Achviement> {
}