package ru.wherebackend.vtbmoretech.screen.achviement;

import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.event.Achviement;

@UiController("vtbmt_Achviement.browse")
@UiDescriptor("achviement-browse.xml")
@LookupComponent("achviementsTable")
public class AchviementBrowse extends StandardLookup<Achviement> {
}