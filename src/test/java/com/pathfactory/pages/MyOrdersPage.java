package com.pathfactory.pages;

import com.pathfactory.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersPage extends BasePage{
    public MyOrdersPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
DashboardPage dashboardPage = new DashboardPage();
    AccountPage accountPage = new AccountPage();
    @FindBy(xpath = "//div[@class='swatch-opt-1556']//div[@id='option-label-size-143-item-166']")
    public WebElement sizeXS;

    @FindBy(xpath = "//div[@class='swatch-opt-1556']//div[@id='option-label-color-93-item-50']")
    public WebElement colorBlue;

    @FindBy(xpath = "//li[1]//div[1]//div[1]//div[4]//div[1]//div[1]//form[1]//button[1]//span[1]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    public WebElement viewCart;

    @FindBy(xpath = "//button[@data-role='proceed-to-checkout']")
    public WebElement checkOutButton;

    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']//button[@type='submit']/span[.='Next']")
    public WebElement nextButton;

    @FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a/strong")
    public WebElement orderNumber;

public void placeAnOrder(String item){
    searchBox.sendKeys(item);
    searchButton.click();

    sizeXS.click();
    colorBlue.click();
    addToCartButton.click();

    viewCart.click();
    checkOutButton.click();

    // Define the JavascriptExecutor
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    // Execute the click script
    js.executeScript("arguments[0].click();", nextButton);

    // Define the JavascriptExecutor
   // JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    // Execute the click script
    js.executeScript("arguments[0].click();", placeOrderButton);



}
}
