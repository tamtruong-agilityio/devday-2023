package steps;

import actions.ProductsActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.InventoryItem;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductsSteps {

    @Steps
    private ProductsActions productsActions;

    @Then("verify user is able to login to the site")
    public void verify_user_is_able_to_login_to_the_site() {
        productsActions.verifyUserIsAbleToSeeTheProductsPage();
    }

    @When("add the first two items to the cart")
    public void add_the_first_two_items_to_the_cart() {
        productsActions.addTheFirstTwoItems();
    }

    @When("navigate to Your Cart page")
    public void navigate_to_your_cart_page() {
        productsActions.navigateToYourCartPage();
    }

    @When("add items to the cart")
    public void add_items_to_the_cart(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        List<InventoryItem> items = new ArrayList<>();
        rows.forEach(row -> items.add(new InventoryItem(row)));
        productsActions.addItemsToTheCart(items);
    }
}
