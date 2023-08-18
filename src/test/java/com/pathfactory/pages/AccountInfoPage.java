package com.pathfactory.pages;

import com.pathfactory.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInfoPage {
    public AccountInfoPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "lastname")
    public WebElement lastName;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement saveButton;
}
