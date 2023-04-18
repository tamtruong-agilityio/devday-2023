package actions;

import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import pages.CheckoutPage;

import java.time.Duration;

public class CheckoutActions {

    private CheckoutPage checkoutPage;

    public void inputYourInformation() {
        checkoutPage.firstName().waitUntilVisible(Duration.ofSeconds(10));
        checkoutPage.firstName().getWrappedElement().sendKeys("first name");
        checkoutPage.lastName().getWrappedElement().sendKeys("last name");
        checkoutPage.zipCode().getWrappedElement().sendKeys("code");
        checkoutPage.continueButton().click();
    }

    public void clickOnFinishButton() {
        checkoutPage.finishButton().click();
    }

    public void verifyAbleToSeeTheCheckoutComplete() {
        checkoutPage.checkoutComplete().waitUntilVisible(Duration.ofSeconds(10));
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(checkoutPage.checkoutComplete().isPresent()).isTrue();
        assertions.assertThat(checkoutPage.pageTitle().getText()).isEqualTo("Checkout: Complete!");
        assertions.assertThat(checkoutPage.completeText().getText()).isEqualTo("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        assertions.assertAll();
    }
}
