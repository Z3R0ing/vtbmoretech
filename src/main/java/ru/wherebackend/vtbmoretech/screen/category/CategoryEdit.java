package ru.wherebackend.vtbmoretech.screen.category;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.market.Category;

@UiController("vtbmt_Category.edit")
@UiDescriptor("category-edit.xml")
@EditedEntityContainer("categoryDc")
public class CategoryEdit extends StandardEditor<Category> {
}