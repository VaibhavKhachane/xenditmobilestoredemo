/**
 * Helper file for Wait
 * Currently not useful due to some technical challenges
 * @author  Vaibhav Khachane
 * @since   26/03/2020
 */
package Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitHelper{

    public  AndroidDriver<MobileElement> driver;

    public WaitHelper(AndroidDriver<MobileElement> driver){

        this.driver = driver;
    }

    //Explicit Wait
    public void WaitForElement(WebElement element, long timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //Explicit Wait
    public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //Explicit Wait
    public void pageLoadTime(long timeout, TimeUnit unit){
        driver.manage().timeouts().pageLoadTimeout(timeout, unit);

    }

    //Explicit Fluent Wait
    private Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        Wait<WebDriver> fWait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(timeOutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
        return fWait;
    }
    public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec){
        Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryInMiliSec);
        fwait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}