package com.cydeo.utilities;

/*
In this class only general utility methods that are not related to some specific page.
 */

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    /*
    This method will accept int(in seconds) and execute Thread.sleep for given duration
     */
    public static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    /*
    This method accepts 3 arguments.
    Arg1:webdriver
    Arg2:expectedInUrl: for verify if the url contains given String.
    -If condition matches, will break loop.
    Args3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(String expectedInUrl,String expectedInTitle){

/*
    This method accepts a String "exceptedTitle" and Asserts if it is true
     */

        Set<String> allWindowsHandles=Driver.getDriver().getWindowHandles();

        for (String each:allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current Url = " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }


    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }

    public static void waitForInvisibility(WebElement webElement){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    /**
     * This method will accept a String expected value and compare with actual URL CONTAİNS the value.
     * @param expectedInUrl
     */
    public static void verifyURLContains(String expectedInUrl){
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedInUrl));
    }










}

