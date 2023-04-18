package helpers;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Coordinates;

import java.time.Duration;

@Slf4j
public abstract class AbstractGuiElement extends PageObject implements IGuiElement {

    protected String name;
    protected WebElementFacade element;

    public AbstractGuiElement(WebElementFacade element) {
        this.element = element;
    }

    public AbstractGuiElement(WebElementFacade element, String name) {
        this(element);
        this.name = name;
    }

    @Override
    public WebElementFacade getWrappedElement() {
        return this.element;
    }

    @Override
    public String getGuiElementName() {
        return this.name;
    }

    @Override
    public void click() {
        try {
            getWrappedElement().waitUntilClickable().click();
        } catch (NoSuchElementException e) {
            log.error("Element should be [Clickable]", e);
            throw new IllegalStateException(e.getMessage());
        }
    }

    @Override
    public void doubleClick() {
        withAction().doubleClick(getWrappedElement()).build().perform();
    }

    @Override
    public void clickWithAction() {
        withAction().click(getWrappedElement()).build().perform();
    }

    @Override
    public void hoverOver() {
        withAction().moveToElement(getWrappedElement()).build().perform();
    }

    @Override
    public void clickToXOffsetAndYOffset(int xOffset, int yOffset) {
        withAction().moveToElement(getWrappedElement(), xOffset, yOffset).click().build().perform();
    }

    @Override
    public Dimension getElementSize() {
        return getWrappedElement().getSize();
    }

    @Override
    public String getText() {
        return getWrappedElement().getText();
    }

    @Override
    public String getAttribute(String attributeName) {
        return getWrappedElement().waitUntilVisible().getAttribute(attributeName);
    }

    @Override
    public String getCssValue(String attributeName) {
        return getWrappedElement().waitUntilVisible().getCssValue(attributeName);
    }

    @Override
    public String getValue() {
        return getWrappedElement().getAttribute("value");
    }

    @Override
    public void scrollByCoordinates() {
        Coordinates coordinates = getWrappedElement().getCoordinates();
        coordinates.inViewPort();
    }

    @Override
    public void scrollIntoView() {
        var driver = Serenity.getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWrappedElement());
    }

    @Override
    public boolean isPresent() {
        try {
            return getWrappedElement().isPresent();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isVisible() {
        try {
            return getWrappedElement().isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isClickable() {
        try {
            return getWrappedElement().isClickable();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isAttributeValuePresent(String attributeName) {
        try {
            if (null != getWrappedElement().getAttribute(attributeName)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public void waitUntilText(String text, Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> getWrappedElement().getText().equals(text));
    }

    @Override
    public void waitUntilAttributeText(String attributeName, String text, Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> getWrappedElement().getAttribute(attributeName).equals(text));
    }

    @Override
    public void waitUntilAttributeNotPresent(String attributeName, Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> !isAttributeValuePresent(attributeName));
    }

    @Override
    public void waitUntilAttributeIsPresent(String attributeName, Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> isAttributeValuePresent(attributeName));
    }

    @Override
    public void waitUntilAttributeNotContains(String attributeName, String text, Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> !getWrappedElement().getAttribute(attributeName).contains(text));
    }

    @Override
    public void waitUntilVisible() {
        getWrappedElement().waitUntilVisible();
    }

    @Override
    public void waitUntilVisible(Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> isVisible() == true);
    }

    @Override
    public void waitUntilVisible(Duration waitAtMost, Duration interval) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(interval)
                .until(() -> isVisible() == true);
    }

    @Override
    public void waitUntilNotVisible() {
        getWrappedElement().waitUntilNotVisible();
    }

    @Override
    public void waitUntilNotVisible(Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> isVisible() == false);
    }

    @Override
    public void waitUntilPresent() {
        getWrappedElement().waitUntilPresent();
    }

    @Override
    public void waitUntilPresent(Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> isPresent() == true);
    }

    @Override
    public void waitUntilClickable(Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> isClickable() == true);
    }

    @Override
    public void scrollToLeft() {
        var driver = Serenity.getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].scrollLeft = 0", getWrappedElement());
        waitABit(1000);
    }

    @Override
    public void scrollToRight() {
        var driver = Serenity.getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", getWrappedElement());
        waitABit(1000);
    }

    @Override
    public void scrollElementToTop() {
        var driver = Serenity.getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWrappedElement());
        waitABit(1000);
    }

    @Override
    public void scrollElementToBottom() {
        var driver = Serenity.getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWrappedElement());
        waitABit(1000);
    }

    @Override
    public void scrollElementToCenter() {
        var driver = Serenity.getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", getWrappedElement());
        waitABit(1000);
    }
}
