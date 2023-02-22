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




    @FindBy(xpath = "//input[@name=\"state\"]")
    public WebElement stateInput;

    @FindBy(name = "product")
    public WebElement moneyCog;

    @FindBy(name = "quantity")
    public WebElement quantityInput;

    @FindBy(name = "name")
    public WebElement nameInput;

    @FindBy(name = "street")
    public WebElement streetInput;

    @FindBy(name = "city")
    public WebElement cityInput;

    @FindBy(name = "state")
    public WebElement stateInput2;

    @FindBy(name = "zip")
    public WebElement zipInput;

    @FindBy(name = "cardNo")
    public WebElement cardInput;

    @FindBy(name = "cardExp")
    public WebElement cardExpInput;


    

    

}
