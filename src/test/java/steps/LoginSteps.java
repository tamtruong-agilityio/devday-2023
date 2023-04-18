package steps;

import actions.LoginActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginSteps {

    @Steps
    private LoginActions loginActions;

    @Given("Login page is opened")
    public void login_page_is_opened() {
        loginActions.openLoginPage();
    }

    @Then("verify user is able to see the Login page")
    public void verify_user_is_able_to_see_the_login_page() {
        loginActions.verifyDefaultFieldsAndFunctions();
    }

    @When("input information with specify username {string} and password {string}")
    public void input_user_with_password(String userName, String password) {
        loginActions.inputUserNameAndPassword(userName, password);
    }

    @Then("verify user is able to see error message on the page")
    public void verify_user_is_able_to_see_error_message_on_the_page() {
        loginActions.verifyTheLookedOutMessageIsDisplayed();
    }

}
