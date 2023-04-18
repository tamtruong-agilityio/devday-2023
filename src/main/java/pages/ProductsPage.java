package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class ProductsPage extends UIInteractionSteps {

    private final By
            page_header = By.xpath("//div[@class='app_logo']"),
            page_title = By.xpath("//span[@class='title']"),
            cart_container = By.id("shopping_cart_container"),
            inventory_buttons = By.xpath("//button[contains(@class, 'btn_inventory')]"),
            login_button = By.id("login-button");

    public IWebElement pageHeader() {return new WebElement($(page_header));}

    public IWebElement pageTitle() {return new WebElement($(page_title));}

    public IWebElement cartButton() {return new WebElement($(cart_container));}

    public ListOfWebElementFacades inventory_buttons() {return ($$(inventory_buttons)); }

    public IWebElement loginButton() {return new WebElement($(login_button));}

}
