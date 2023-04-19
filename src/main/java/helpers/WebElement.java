package helpers;

import net.serenitybdd.core.pages.WebElementFacade;

public class WebElement extends AbstractGuiElement implements IWebElement {
    public WebElement(WebElementFacade element) {
        super(element);
    }

    public WebElement(WebElementFacade element, String name) {
        super(element, name);
    }
}
