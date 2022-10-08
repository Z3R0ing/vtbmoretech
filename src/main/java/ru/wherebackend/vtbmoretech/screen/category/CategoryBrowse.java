package ru.wherebackend.vtbmoretech.screen.category;

import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.market.Category;

@UiController("vtbmt_Category.browse")
@UiDescriptor("category-browse.xml")
@LookupComponent("categoriesTable")
public class CategoryBrowse extends StandardLookup<Category> {
}