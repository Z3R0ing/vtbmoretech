package ru.wherebackend.vtbmoretech.screen.news;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.blog.News;

@UiController("vtbmt_News.edit")
@UiDescriptor("news-edit.xml")
@EditedEntityContainer("newsDc")
public class NewsEdit extends StandardEditor<News> {
}