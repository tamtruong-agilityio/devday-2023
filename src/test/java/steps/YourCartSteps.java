package steps;

import actions.YourCartActions;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class YourCartSteps {

    @Steps
    private YourCartActions yourCartActions;

    @When("navigate to the Checkout page")
    public void navigate_to_the_checkout_page() {
        yourCartActions.navigateToCheckoutPage();
    }

    @When("verify user is able to see items on Your Cart page")
    public void verify_user_is_able_to_see_items_on_your_cart_page() {
        yourCartActions.verifyItemsOnYourCart();
    }
}
