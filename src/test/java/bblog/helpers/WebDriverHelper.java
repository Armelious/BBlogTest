package bblog.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriverHelper(Hooks hooks) {
        driver = hooks.getDriver();
        wait = new WebDriverWait(driver,10);
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Wait for an element to be clickable before clicking
     * @param locator WebElement By locator
     */
    public void clickElement(By locator) {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }
        catch (TimeoutException e)
        {
            System.out.println("Count not click element <" + locator.toString() + ">");
        }
    }

    /**
     * Wait for an element to be clickable before clicking.
     * Then wait for page to load by element becoming stale.
     * @param locator WebElement By locator
     */
    public void clickElementAndWait(By locator) {
        clickElement(locator);
        try {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
        }
        catch (TimeoutException e)
        {
            System.out.println("Page did not change <" + locator.toString() + ">");
        }

    }
}
