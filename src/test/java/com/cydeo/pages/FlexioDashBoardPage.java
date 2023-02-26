package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlexioDashBoardPage {

    public FlexioDashBoardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//span[@class='oe_topbar_name']")
    public WebElement fullName;
    @FindBy (xpath = "//a[.='Log out']")
    public WebElement logOutLink;

    public void logout(){
        fullName.click();
        logOutLink.click();
    }
}
