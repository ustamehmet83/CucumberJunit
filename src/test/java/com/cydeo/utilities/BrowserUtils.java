package com.cydeo.utilities;

/*
In this class only general utility methods that are not related to some specific page.
 */

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    /*
    This method will accept int(in seconds) and execute Thread.sleep for given duration
     */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }
    /*
    This method accepts 3 arguments.
    Arg1:webdriver
    Arg2:expectedInUrl: for verify if the url contains given String.
    -If condition matches, will break loop.
    Args3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle) {
/*
    This method accepts a String "exceptedTitle" and Asserts if it is true
     */
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current Url = " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void waitForInvisibility(WebElement webElement) {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    /**
     * This method will accept a String expected value and compare with actual URL CONTAİNS the value.
     *
     * @param expectedInUrl
     */
    public static void verifyURLContains(String expectedInUrl) {
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedInUrl));
    }

    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options' text in a List of String
     *
     * @param dropdownElement
     * @return
     */

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement) {
        Select select = new Select(dropdownElement);
        //List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        //List of all ACTUAL month <options> as a String
        List<String> actualOptionAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionAsString.add(each.getText());
        }
        return actualOptionAsString;
    }

    /**
     * This method accept a group radio buttons as a List of Web element.
     * It will loop through the list, and click to the radio button with
     * provided attributeValue
     *
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioBtnWithString(List<WebElement> radioButtons, String attributeValue) {
        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equals(attributeValue)) {
                each.click();
            }
        }
    }


}

