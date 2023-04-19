package actions;

import helpers.Storage;
import models.InventoryItem;
import pages.ProductsPage;

import java.time.Duration;
import java.util.List;

import static helpers.StorageKey.INVENTORY_ITEMS;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductsActions {

    private ProductsPage productsPage;

    public void verifyUserIsAbleToSeeTheProductsPage() {
        productsPage.pageHeader().waitUntilVisible(Duration.ofMinutes(1));
        assertThat(productsPage.pageTitle().getText()).isEqualTo("Products");
    }

    public void addTheFirstTwoItems() {
        productsPage.pageHeader().waitUntilVisible(Duration.ofMinutes(1));
        productsPage.inventory_buttons().get(0).click();
        productsPage.inventory_buttons().get(1).click();
    }

    public void navigateToYourCartPage() {
        productsPage.cartButton().click();
    }

    public void addItemsToTheCart(List<InventoryItem> items) {
        for (var item: items) {
            productsPage.inventory_buttons().get(item.getIndex() - 1).click();
        }
        Storage.getStorage().saveObjectValue(INVENTORY_ITEMS, items);
    }
}
