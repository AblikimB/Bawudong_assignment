package com.pathfactory.pages;

import com.pathfactory.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@title='Search']")
    public WebElement searchButton;
}
