package pages;

import helpers.IGuiElement;
import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class LoginPage extends UIInteractionSteps {

    private final By
            page_header = By.xpath("//div[@class='login_logo']"),
            user_name = By.id("user-name"),
            user_password = By.id("password"),
            login_button = By.id("login-button"),
            error_message = By.xpath("//div[contains(@class,'error-message-container error')]");

    public IWebElement pageHeader() {
        return new WebElement($(page_header));
    }

    public IWebElement userName() {
        return new WebElement($(user_name));
    }

    public IWebElement userPassword() {
        return new WebElement($(user_password));
    }

    public IWebElement loginButton() {
        return new WebElement($(login_button));
    }

    public IWebElement errorMessage() {
        return new WebElement($(error_message));
    }
}
