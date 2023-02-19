package com.cydeo.step_definitions;

/*
In the class we will be able to pass pre- & post- conditions to each scenario and each step
 */

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    // import from io.cucumber.java not from junit
    @Before(order = 0)
    public void setupScenario() {
        System.out.println("====Setting up browser using cucumber @Before");

    }

    @Before(value = "@login", order = 1)
    public void setupScenarioForLogins() {
        System.out.println("====this will only apply to scenario with @login tag");
    }

    @Before(value = "@db", order = -1)
    public void setupForDatabaseScenarios() {
        System.out.println("====this will only apply to scenario with @db");
    }

    @After
    public void teardownScenario(Scenario scenario) {

        //scenario.isFailed()--> if scenario fails this method will return TRUE boolean value
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

    @BeforeStep
    public void setupStep() {
        System.out.println("------------> applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("------------> applying tearDown using @AfterStep");
    }
}
