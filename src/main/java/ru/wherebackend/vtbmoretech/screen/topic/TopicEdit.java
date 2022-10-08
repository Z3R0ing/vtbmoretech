package ru.wherebackend.vtbmoretech.screen.topic;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.blog.Topic;

@UiController("vtbmt_Topic.edit")
@UiDescriptor("topic-edit.xml")
@EditedEntityContainer("topicDc")
public class TopicEdit extends StandardEditor<Topic> {
}