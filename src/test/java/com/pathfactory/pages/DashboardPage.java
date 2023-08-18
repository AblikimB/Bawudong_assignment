package com.pathfactory.pages;

import com.pathfactory.utilities.BrowserUtils;
import com.pathfactory.utilities.ConfigurationReader;
import com.pathfactory.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage {

    public DashboardPage() { PageFactory.initElements(Driver.getDriver(),this);

    }

    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();

    @FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
    public WebElement customerMenu;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
    public WebElement signOut;

    @FindBy(className = "base")
    public WebElement signOutMsg;

    @FindBy(xpath = "//span[starts-with(text(),'Welcome')]")
    public WebElement loggedInMsg;



    public void onDashboardPage(){
        homePage.onHomePage("env");
        signInPage.signIn(ConfigurationReader.getProperty("email"), ConfigurationReader.getProperty("password"));
    }
    public boolean isOnDashboardPage() {
        boolean isLoggedInSectionVisible = BrowserUtils.waitForVisibility(loggedInMsg,10).isDisplayed();
        if (isLoggedInSectionVisible) {
            System.out.println("User is logged in. Status: " + loggedInMsg.getText());
            return true; // User is on the account page (logged in)
        } else {
            return false; // User is not on the account page (not logged in)
        }
    }


}
