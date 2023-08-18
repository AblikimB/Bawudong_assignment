package com.pathfactory.pages;


import com.pathfactory.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class AccountPage {
    public AccountPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    DashboardPage dashboardPage = new DashboardPage();
    @FindBy(xpath = "//span[normalize-space()='Edit']")
    public WebElement editButton;


    @FindBy(xpath = "//div[contains(text(), 'You saved the account information.')]")
    public WebElement successMsg;

    @FindBy(xpath = "//*[@id=\"block-collapsible-nav\"]/ul/li")
    public List<WebElement> myAccountMenu;

    @FindBy(xpath = "//a[normalize-space()='My Orders']")
    public WebElement myOrders;

    @FindBy(xpath = "//*[@id=\"my-orders-table\"]/tbody")
    public WebElement myOrderList;

    @FindBy(xpath = "//a[normalize-space()='My Product Reviews']")
    public WebElement myProductReviews;
    @FindBy(xpath = "//ol[@class='product-items widget-product-grid']/li[1]")
    public WebElement product;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/strong/a")
    public WebElement productName;

    @FindBy(xpath = "//li[1]//div[1]//div[1]//div[4]//div[1]//div[2]//a[1]")
    public WebElement addToWishList;

    @FindBy(xpath = "//a[normalize-space()='Address Book']")
    public WebElement addressBook;

    @FindBy(xpath = "//a[normalize-space()='Account Information']")
    public WebElement accountInformation;

    public void onAccountPage(){
        dashboardPage.onDashboardPage();
        dashboardPage.customerMenu.click();
        dashboardPage.myAccount.click();
    }

}
