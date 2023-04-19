package actions;

import helpers.Storage;
import models.InventoryItem;
import org.assertj.core.api.SoftAssertions;
import pages.YourCartPage;

import java.time.Duration;
import java.util.List;

import static helpers.StorageKey.INVENTORY_ITEMS;

public class YourCartActions {

    private YourCartPage yourCartPage;

    public void navigateToCheckoutPage() {
        yourCartPage.pageHeader().waitUntilVisible(Duration.ofSeconds(10));
        yourCartPage.checkoutButton().click();
    }

    public void verifyItemsOnYourCart() {
        yourCartPage.pageHeader().waitUntilVisible(Duration.ofSeconds(10));
        var items = (List<InventoryItem>)Storage.getStorage().getObject(INVENTORY_ITEMS);
        var itemNames = yourCartPage.inventory_item_names().texts();
        SoftAssertions assertions = new SoftAssertions();
        for (var item: items) {
            assertions.assertThat(itemNames).contains(item.getName());
        }
        assertions.assertAll();
    }
}
