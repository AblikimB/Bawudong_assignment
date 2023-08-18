package com.pathfactory.step_definitions;

import com.github.javafaker.Faker;
import com.pathfactory.pages.AccountInfoPage;
import com.pathfactory.pages.AccountPage;
import com.pathfactory.pages.AddressBookPage;
import com.pathfactory.pages.DashboardPage;
import com.pathfactory.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddressBook_stepdefs {

    AddressBookPage addressBookPage = new AddressBookPage();

    Faker faker = new Faker();

    String originalToolbarNumber;

    @Given("User is on the Address Book page")
    public void userIsOnTheAddressBookPage() {
        addressBookPage.onAddressBookPage();
    }

    @When("User adds a new address")
    public void userAddsANewAddress() {
        originalToolbarNumber = addressBookPage.toolbarNumber.getText();
        addressBookPage.addNewAddressButton.click();
        addressBookPage.inputPhoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
        addressBookPage.inputStreet1.sendKeys(faker.address().streetAddress());
        addressBookPage.inputCity.sendKeys(faker.address().city());
        addressBookPage.inputZipCode.sendKeys(faker.address().zipCode());
        BrowserUtils.selectFromDropdown(addressBookPage.selectCountry, "United States");
        BrowserUtils.selectFromDropdown(addressBookPage.selectRegion, "Texas");
        addressBookPage.saveAddressButton.click();
    }


    @Then("User should see it under additional address entries")
    public void userShouldSeeItUnderAdditionalAddressEntries() {
        Assert.assertNotEquals(addressBookPage.toolbarNumber.getText(), originalToolbarNumber);
        addressBookPage.deleteButton.click();
        addressBookPage.okButton.click();


    }

    @When("User enters invalid zip code")
    public void userEntersInvalidZipCode() {
        addressBookPage.addNewAddressButton.click();
        addressBookPage.inputZipCode.sendKeys("1");

    }

    @Then("User should see a warning message")
    public void userShouldSeeAWarningMessage() {
        Assert.assertTrue(addressBookPage.zipErrorMessage.isDisplayed());
    }


    @When("User tries to add a new address without required fields")
    public void userAddANewAddressWithoutRequiredFields() {
        addressBookPage.addNewAddressButton.click();
        addressBookPage.saveAddressButton.click();
    }


    @Then("the User should be prompted to fill in the missing fields")
    public void theUserShouldBePromptedToFillInTheMissingFields() {
        Assert.assertTrue(addressBookPage.requiredFieldErrorMsg.isDisplayed());
    }
}
