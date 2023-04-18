package actions;

import net.serenitybdd.core.Serenity;
import org.assertj.core.api.SoftAssertions;
import pages.LoginPage;

import java.time.Duration;

public class LoginActions {

    private LoginPage loginPage;

    public void openLoginPage() {
        Serenity.getDriver().get("https://www.saucedemo.com/");
    }

    public void verifyDefaultFieldsAndFunctions() {
        loginPage.pageHeader().waitUntilVisible(Duration.ofMinutes(1));
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(loginPage.userName().isPresent()).isTrue();
        assertions.assertThat(loginPage.userPassword().isPresent()).isTrue();
        assertions.assertThat(loginPage.loginButton().isPresent()).isTrue();
        assertions.assertAll();
    }

    public void inputUserNameAndPassword(String userName, String password) {
        loginPage.pageHeader().waitUntilVisible(Duration.ofMinutes(1));
        loginPage.userName().getWrappedElement().sendKeys(userName);
        loginPage.userPassword().getWrappedElement().sendKeys(password);
        loginPage.loginButton().click();
    }

    public void verifyTheLookedOutMessageIsDisplayed() {
        loginPage.errorMessage().waitUntilVisible(Duration.ofSeconds(30));
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(loginPage.errorMessage().isPresent()).isTrue();
        assertions.assertThat(loginPage.errorMessage().getText()).isEqualTo("Epic sadface: Sorry, this user has been locked out.");
        assertions.assertAll();
    }
}
