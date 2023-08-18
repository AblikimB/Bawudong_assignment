package com.pathfactory.pages;

import com.pathfactory.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    HomePage homePage = new HomePage();
    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(name = "login[username]")
    public WebElement inputEmail;
    @FindBy(name = "login[password]")
    public WebElement inputPassword;

    @FindBy(name = "send")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div")
    public WebElement errorMsg;

    public void signIn(String email,String password){
        homePage.signIn.click();
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        signInButton.click();
    }
}
