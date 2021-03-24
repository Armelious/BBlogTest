package bblog.helpers;

import com.sun.webkit.WebPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import java.time.Instant;

public class WebDriverHelper {

    WebDriver driver;

    WebDriverWait wait;

    public WebDriverHelper(Hooks hooks) {
        driver = hooks.getDriver();
        wait = new WebDriverWait(driver,30);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitAndClickElement(By locator)
    {
        try
        {
            this.wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            waitForLinkToGoStale(locator);
        }
        catch (TimeoutException e)
        {
            System.out.println("Count not click element <" + locator.toString() + ">");
        }
    }

    public void waitForLinkToGoStale(By locator) {
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
    }
}
