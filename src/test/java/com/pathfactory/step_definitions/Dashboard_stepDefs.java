package com.pathfactory.step_definitions;

import com.pathfactory.pages.DashboardPage;
import com.pathfactory.pages.HomePage;
import com.pathfactory.pages.SignInPage;
import com.pathfactory.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Dashboard_stepDefs {
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();

    DashboardPage dashboardPage = new DashboardPage();

    @Given("User navigates to the home page")
    public void user_navigates_to_the_home_page() {
            homePage.onHomePage("env");}

    @When("User login with valid credentials")
    public void user_login_with_valid_credentials() {
        signInPage.signIn(ConfigurationReader.getProperty("email"), ConfigurationReader.getProperty("password"));
    }
    @Then("User should see the account dashboard")
    public void user_should_see_the_account_dashboard() {
            Assert.assertTrue(dashboardPage.isOnDashboardPage());
        }

    @Given("User is on the Sign In page")
    public void userIsOnTheSignInPage() {
        homePage.onHomePage("env");
        homePage.signIn.click();
    }

    @When("User attempts to sign in with incorrect credentials")
    public void userAttemptsToSignInWithIncorrectCredentials() {
        signInPage.inputEmail.sendKeys("fdsf@gfdsgf.com");
        signInPage.inputPassword.sendKeys("gfdsg");
        signInPage.signInButton.click();
    }

    @Then("User should see an error message")
    public void userShouldSeeAnErrorMessage() {
        Assert.assertTrue(signInPage.errorMsg.isDisplayed());
    }

    @Given("User is logged in")
    public void userIsLoggedIn() {
        dashboardPage.onDashboardPage();
    }

    @When("User clicks on Sign Out")
    public void userClicksOnSignOut() {
        dashboardPage.customerMenu.click();
        dashboardPage.signOut.click();
    }


    @Then("User should see successful sign out message")
    public void userShouldSeeSuccessfulSignOutMessage() {
        Assert.assertTrue(dashboardPage.signOutMsg.isDisplayed());
    }

    @And("User should see the option to Sign In")
    public void userShouldSeeTheOptionToSignIn() {
        Assert.assertTrue(homePage.signIn.isDisplayed());
    }
}


