package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FidexioLoginPage {

    public FidexioLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy (xpath = "//input[@id='login']")
    public WebElement loginUser;
    @FindBy(xpath="//input[@id='password']")
    public WebElement loginPass;
    @FindBy (xpath = "//button[.='Log in']")
    public WebElement loginBtn;

    public void login(String username,String password){
        loginUser.sendKeys(username);
      loginPass.sendKeys(password);
      loginBtn.click();
    }




}


