package ru.wherebackend.vtbmoretech.screen.topic;

import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.blog.Topic;

@UiController("vtbmt_Topic.browse")
@UiDescriptor("topic-browse.xml")
@LookupComponent("topicsTable")
public class TopicBrowse extends StandardLookup<Topic> {
}