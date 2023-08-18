@smoke
Feature: Registered Customers section

  Background:
    Given User is on My Account Page

  Scenario: User should be able to see all my account menus
    Then User should see below menus
      | My Account               |
      | My Orders                |
      | My Downloadable Products |
      | My Wish List             |
      | Address Book             |
      | Account Information      |
      | Stored Payment Methods   |
      | My Product Reviews       |


  Scenario: Update Account Details
    When User clicks Edit
    And User updates account information
    Then User should see updated details


  Scenario: Verify new orders are added to My Orders
    When User placed an <order>
    Then User should see that order under My Orders


  Scenario: Verify new review added to My Product Reviews
    When User writes a new review for a product
    Then User should see that review in My Product Reviews


  Scenario: Verify a product is added to My Wish List
    When User adds a product to wish list
    Then User should see that product in My Wish List




