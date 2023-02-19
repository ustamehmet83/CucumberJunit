package com.cydeo.step_definitions;

/*
In the class we will be able to pass pre- & post- conditions to each scenario and each step
 */

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {

    // import from io.cucumber.java not from junit
    @Before(order=0)
    public void setupScenario() {
        System.out.println("====Setting up browser using cucumber @Before");

    }

    @Before(value = "@login", order = 1)
    public void setupScenarioForLogins() {
        System.out.println("====this will only apply to scenario with @login tag");
    }

    @Before(value="@db",order=-1)
    public void setupForDatabaseScenarios() {
        System.out.println("====this will only apply to scenario with @db");
    }

    @After
    public void teardownScenario() {
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
