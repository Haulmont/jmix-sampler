package io.jmix.sampler.screen.ui.components.table.itemclick;

import io.jmix.core.MetadataTools;
import io.jmix.sampler.entity.Customer;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.BaseAction;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("table-item-click")
@UiDescriptor("table-item-click.xml")
public class TableItemClickSample extends ScreenFragment {

    @Autowired
    protected Table<Customer> customerTable;
    @Autowired
    protected Notifications notifications;
    @Autowired
    protected MetadataTools metadataTools;

    @Subscribe
    protected void onInit(InitEvent event) {
        customerTable.setItemClickAction(new BaseAction("itemClickAction")
                .withHandler(actionPerformedEvent -> {
                    Customer customer = customerTable.getSingleSelected();
                    if (customer != null) {
                        notifications.create()
                                .withCaption("Item clicked for: " + metadataTools.getInstanceName(customer))
                                .show();
                    }
                }));

        customerTable.setEnterPressAction(new BaseAction("enterPressAction")
                .withHandler(actionPerformedEvent -> {
                    Customer customer = customerTable.getSingleSelected();
                    if (customer != null) {
                        notifications.create()
                                .withCaption("Enter pressed for: " + metadataTools.getInstanceName(customer))
                                .show();
                    }
                }));
    }
}
