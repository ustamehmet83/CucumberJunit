package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage{

    public OrderPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//select[@name='product']")
    public WebElement productDropdown;

    @FindBy (xpath = "//input[@placeholder='Enter amount desired']")
    public WebElement inputQuantity;
    @FindBy (xpath = "//input[@placeholder='Full name of the customer']")
    public WebElement inputCustomerName;
    @FindBy (xpath = "//input[@placeholder='Street address of the customer']")
    public WebElement inputStreet;
    @FindBy (xpath = "//input[@placeholder='City where the customer lives']")
    public WebElement inputCity;
    @FindBy (xpath = "//input[@placeholder='State where the customer lives']")
    public WebElement inputState;
    @FindBy (xpath = "//input[@name='zip']")
    public WebElement inputZipCode;
    @FindBy (name = "card")
    public List<WebElement> cardType;

    @FindBy (xpath = "//input[@placeholder='The number on the card']")
    public WebElement inputNumberOnCard;
    @FindBy (xpath = "//input[@placeholder='e.g. 04/24']")
    public WebElement inputExpiryDate;
    @FindBy (xpath = "//button[.='Process Order']")
    public WebElement inputProcessOrder;
    @FindBy (xpath = "//tbody//th/following-sibling::td[1]")
    public WebElement firstRowOfTable;

}
