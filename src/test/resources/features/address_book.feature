@smoke
Feature: Address Management
  Background:
    Given User is on the Address Book page


  Scenario: Add new additional address
    When User adds a new address
    Then User should see it under additional address entries


  Scenario:  Adding Address with Invalid Zip Code
    When User enters invalid zip code
    Then User should see a warning message


  Scenario: Adding incomplete address
    When User tries to add a new address without required fields
    Then the User should be prompted to fill in the missing fields
