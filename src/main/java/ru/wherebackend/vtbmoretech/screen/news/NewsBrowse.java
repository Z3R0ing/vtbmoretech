package ru.wherebackend.vtbmoretech.screen.news;

import io.jmix.ui.screen.*;
import ru.wherebackend.vtbmoretech.entity.News;

@UiController("vtbmt_News.browse")
@UiDescriptor("news-browse.xml")
@LookupComponent("newsTable")
public class NewsBrowse extends StandardLookup<News> {
}