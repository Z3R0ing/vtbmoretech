package ru.wherebackend.vtbmoretech.screen.achviement;

import io.jmix.ui.screen.*;
import ru.wherebackend.vtbmoretech.entity.Achviement;

@UiController("vtbmt_Achviement.browse")
@UiDescriptor("achviement-browse.xml")
@LookupComponent("achviementsTable")
public class AchviementBrowse extends StandardLookup<Achviement> {
}