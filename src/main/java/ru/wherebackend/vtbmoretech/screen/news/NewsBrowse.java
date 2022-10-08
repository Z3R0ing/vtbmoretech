package ru.wherebackend.vtbmoretech.screen.news;

import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.blog.News;

@UiController("vtbmt_News.browse")
@UiDescriptor("news-browse.xml")
@LookupComponent("newsTable")
public class NewsBrowse extends StandardLookup<News> {
}