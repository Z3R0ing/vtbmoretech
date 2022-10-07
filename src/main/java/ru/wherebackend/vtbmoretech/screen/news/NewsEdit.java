package ru.wherebackend.vtbmoretech.screen.news;

import io.jmix.ui.screen.*;
import ru.wherebackend.vtbmoretech.entity.News;

@UiController("vtbmt_News.edit")
@UiDescriptor("news-edit.xml")
@EditedEntityContainer("newsDc")
public class NewsEdit extends StandardEditor<News> {
}