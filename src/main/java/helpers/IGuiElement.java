package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WrapsElement;

import java.time.Duration;

public interface IGuiElement extends WrapsElement {

    String getGuiElementName();

    void click();

    void doubleClick();

    void clickWithAction();

    void hoverOver();

    void clickToXOffsetAndYOffset(int xOffset, int yOffset);

    Dimension getElementSize();

    String getText();

    String getAttribute(String attributeName);

    String getCssValue(String attributeName);

    String getValue();

    void scrollByCoordinates();

    void scrollIntoView();

    boolean isPresent();

    boolean isVisible();

    boolean isClickable();

    boolean isAttributeValuePresent(String attribute);

    void waitUntilAttributeText(String attributeName, String text, Duration waitAtMost);

    void waitUntilText(String text, Duration waitAtMost);

    void waitUntilAttributeNotPresent(String attributeName, Duration waitAtMost);

    void waitUntilAttributeIsPresent(String attributeName, Duration waitAtMost);

    void waitUntilAttributeNotContains(String attributeName, String text, Duration waitAtMost);

    void waitUntilVisible();

    void waitUntilVisible(Duration waitAtMost);

    void waitUntilVisible(Duration waitAtMost, Duration interval);

    void waitUntilNotVisible();

    void waitUntilNotVisible(Duration waitAtMost);

    void waitUntilPresent();

    void waitUntilPresent(Duration waitAtMost);

    void waitUntilClickable(Duration waitAtMost);

    void scrollToLeft();

    void scrollToRight();

    void scrollElementToTop();

    void scrollElementToBottom();

    void scrollElementToCenter();
}
