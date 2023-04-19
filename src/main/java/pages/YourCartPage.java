package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class YourCartPage extends UIInteractionSteps {

    private final By
            page_header = By.xpath("//div[@class='app_logo']"),
            page_title = By.xpath("//span[@class='title']"),
            cart_container = By.id("shopping_cart_container"),
            checkout_button = By.id("checkout"),
            inventory_item_names = By.xpath("//div[@class='inventory_item_name']");

    public IWebElement pageHeader() {
        return new WebElement($(page_header));
    }

    public IWebElement pageTitle() {
        return new WebElement($(page_title));
    }

    public IWebElement cartButton() {
        return new WebElement($(cart_container));
    }

    public IWebElement checkoutButton() {
        return new WebElement($(checkout_button));
    }

    public ListOfWebElementFacades inventory_item_names() {return ($$(inventory_item_names)); }
}
