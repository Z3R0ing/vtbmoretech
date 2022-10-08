package ru.wherebackend.vtbmoretech.screen.order;

import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import ru.wherebackend.vtbmoretech.entity.market.Order;

@UiController("vtbmt_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
public class OrderEdit extends StandardEditor<Order> {
}