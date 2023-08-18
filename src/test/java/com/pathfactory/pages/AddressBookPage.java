package com.pathfactory.pages;

import com.pathfactory.utilities.Driver;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressBookPage {
    public AddressBookPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    DashboardPage dashboardPage = new DashboardPage();
    AccountPage accountPage = new AccountPage();

    @FindBy(xpath = "//span[normalize-space()='Add New Address']")
    public WebElement addNewAddressButton;

    @FindBy(id = "firstname")
    public WebElement inputFirstName;

    @FindBy(id = "lastname")
    public WebElement inputLastName;

    @FindBy(id = "telephone")
    public WebElement inputPhoneNumber;

    @FindBy(id = "street_1")
    public WebElement inputStreet1;

    @FindBy(id = "city")
    public WebElement inputCity;

    @FindBy(id = "country")
    public WebElement selectCountry;

    @FindBy(id = "region_id")
    public WebElement selectRegion;

    @FindBy(id = "zip")
    public WebElement inputZipCode;

    @FindBy(xpath = "//button[@title='Save Address']")
    public WebElement saveAddressButton;

    @FindBy(className = "toolbar-number")
    public WebElement toolbarNumber;

    @FindBy(xpath = "//tbody/tr[1]/td[9]/a[2]/span[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//span[normalize-space()='OK']")
    public WebElement okButton;

    @FindBy(xpath = "//span[contains(text(),'Provided Zip/Postal Code seems to be invalid. Exam')]")
    public WebElement zipErrorMessage;

    @FindBy(className = "mage-error")
    public WebElement requiredFieldErrorMsg;



    public void onAddressBookPage(){
//        dashboardPage.onDashboardPage();
//        dashboardPage.customerMenu.click();
//        dashboardPage.myAccount.click();
        accountPage.onAccountPage();
        accountPage.addressBook.click();
    }





}
