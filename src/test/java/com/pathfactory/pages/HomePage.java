package com.pathfactory.pages;

import com.pathfactory.utilities.ConfigurationReader;
import com.pathfactory.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void onHomePage(String environment){
        Driver.getDriver().get(ConfigurationReader.getProperty(environment));
    }

    @FindBy(className = "authorization-link")
    public WebElement signIn;
}
