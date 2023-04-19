package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class CheckoutPage extends UIInteractionSteps {

    private final By
            page_header = By.xpath("//div[@class='app_logo']"),
            page_title = By.xpath("//span[@class='title']"),
            first_name = By.id("first-name"),
            last_name = By.id("last-name"),
            zip_code = By.id("postal-code"),
            continue_button = By.id("continue"),
            finish_button = By.id("finish"),
            checkout_complete = By.id("checkout_complete_container"),
            complete_text = By.xpath("//div[@class='complete-text']");

    public IWebElement pageHeader() {return new WebElement($(page_header));}

    public IWebElement pageTitle() {return new WebElement($(page_title));}

    public IWebElement firstName() {return new WebElement($(first_name));}

    public IWebElement lastName() {return new WebElement($(last_name));}

    public IWebElement zipCode() {return new WebElement($(zip_code));}

    public IWebElement continueButton() {return new WebElement($(continue_button));}

    public IWebElement finishButton() {return new WebElement($(finish_button));}

    public IWebElement checkoutComplete() {return new WebElement($(checkout_complete));}

    public IWebElement completeText() {return new WebElement($(complete_text));}

}
