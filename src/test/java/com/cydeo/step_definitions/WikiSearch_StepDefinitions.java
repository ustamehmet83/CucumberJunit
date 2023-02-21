package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikiSearch_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        wikiSearchPage.searchBox.sendKeys(string);
    }

    @And("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSearchPage.clickBtn.click();
    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        String expectedTitle = string + " - Vikipedi";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Title is not as expected", actualTitle, expectedTitle);
    }

    @Then("User sees {string} is in the main header")
    public void user_sees_steve_jobs_is_in_the_main_header(String string) {
        String expectedHeader = string;
        String actualFirstHeader = wikiSearchPage.firstHeader.getText();
        Assert.assertEquals("Title is not as expected", expectedHeader, actualFirstHeader);
    }

    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String string) {
        String expectedImageHeader = string;
        String actualImageHeader = wikiSearchPage.imageHeader.getText();
        Assert.assertEquals("Title is not as expected", expectedImageHeader, actualImageHeader);
    }


}
