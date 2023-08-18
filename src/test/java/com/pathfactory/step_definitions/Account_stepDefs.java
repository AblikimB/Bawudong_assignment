package com.pathfactory.step_definitions;

import com.github.javafaker.Faker;
import com.pathfactory.pages.*;
import com.pathfactory.utilities.BrowserUtils;
import com.pathfactory.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class Account_stepDefs {
    AccountPage accountPage = new AccountPage();
    DashboardPage dashboardPage = new DashboardPage();
    MyOrdersPage myOrdersPage = new MyOrdersPage();
    ReviewPage reviewPage = new ReviewPage();
    MyWishListPage myWishListPage = new MyWishListPage();
    AccountInfoPage accountInfoPage = new AccountInfoPage();

    Faker faker = new Faker();

    // Define the JavascriptExecutor
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @Given("User is on My Account Page")
    public void userIsOnMyAccountPage() {
        accountPage.onAccountPage();
    }


    @Then("User should see below menus")
    public void userShouldSeeBelowMenus(List<String> expectedMenus) {
        List<String> actualOptionsAsString = BrowserUtils.getElementsText(accountPage.myAccountMenu);
        //System.out.println(actualOptionsAsString);
        Assert.assertEquals(expectedMenus,actualOptionsAsString);
    }

    @When("User clicks Edit")
    public void userClicksEdit() {
        accountPage.editButton.click();
    }

    @And("User updates account information")
    public void userUpdatesAccountInformation() {
        accountInfoPage.firstName.clear();
        accountInfoPage.firstName.sendKeys(faker.name().firstName());
        accountInfoPage.lastName.clear();
        accountInfoPage.lastName.sendKeys(faker.name().lastName());
        accountInfoPage.saveButton.click();
    }

    @Then("User should see updated details")
    public void userShouldSeeUpdatedDetails() {
        Assert.assertTrue(accountPage.successMsg.isDisplayed());
    }

    @When("User placed an <order>")
    public void userPlacedAnOrder() {
        myOrdersPage.placeAnOrder("shirt");
    }

    @Then("User should see that order under My Orders")
    public void userShouldSeeThatOrderUnderMyOrders() {
        String orderNumText = myOrdersPage.orderNumber.getText();
        dashboardPage.customerMenu.click();
        dashboardPage.myAccount.click();
        accountPage.myOrders.click();
        Assert.assertTrue(accountPage.myOrderList.getText().contains(orderNumText));
    }


    @When("User writes a new review for a product")
    public void userWritesANewReviewForAProduct() {
        accountPage.product.click();
        reviewPage.review.click();
        // Execute the click script
        js.executeScript("arguments[0].click();", reviewPage.rating);
        reviewPage.inputNickName.sendKeys(faker.funnyName().name());
        reviewPage.inputSummary.sendKeys(faker.chuckNorris().fact());
        reviewPage.inputReview.sendKeys(faker.chuckNorris().fact());
        reviewPage.submitReviewButton.click();

    }

    @Then("User should see that review in My Product Reviews")
    public void userShouldSeeThatReviewInMyProductReviews() {
        dashboardPage.customerMenu.click();
        dashboardPage.myAccount.click();
        accountPage.myProductReviews.click();
    }

    String productName;
    @When("User adds a product to wish list")
    public void userAddsAProductToWishList() {
        productName = accountPage.productName.getText();
        js.executeScript("arguments[0].click();", accountPage.addToWishList);
    }

    @Then("User should see that product in My Wish List")
    public void userShouldSeeThatProductInMyWishList() {
        //System.out.println(myWishListPage.wishList.getText());
        Assert.assertTrue(myWishListPage.wishList.getText().contains(productName));
    }


}
