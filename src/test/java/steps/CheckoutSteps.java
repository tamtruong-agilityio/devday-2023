package steps;

import actions.CheckoutActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CheckoutSteps {

    @Steps
    private CheckoutActions checkoutActions;

    @When("input your information on the Checkout page")
    public void input_your_information_on_the_checkout_page() {
        checkoutActions.inputYourInformation();
    }

    @When("click on Finish button on the Checkout page")
    public void click_on_finish_button_on_checkout_page() {
        checkoutActions.clickOnFinishButton();
    }

    @Then("verify user is able to see the checkout process is completed")
    public void verify_user_is_able_to_see_the_checkout_process_is_completed() {
        checkoutActions.verifyAbleToSeeTheCheckoutComplete();
    }

}
