
Feature: Sign in to dashboard page

  Scenario: Valid Sign in to dashboard page
    Given User navigates to the home page
    When User login with valid credentials
    Then User should see the account dashboard


  Scenario: Invalid Sign In Attempt

    Given User is on the Sign In page
    When User attempts to sign in with incorrect credentials
    Then User should see an error message


  Scenario: Sign Out

    Given User is logged in
    When User clicks on Sign Out
    Then User should see successful sign out message
    And User should see the option to Sign In