#Author: Chandana
#Keywords Summary :
#Feature: US1525481 - Optum ID sign on
#List of scenarios:
# 1.Optum ID sign on - Successful Login
# 2.Optum ID sign on - Unsuccessful Login
@F243640
Feature: US1525481 - Optum ID sign on
  This feature will provide the ability to provision and grant access to external users (non UHG employees) to an enhanced self service digital provider onboarding application that will allow requests for providers to join UnitedHealthcare Networks.

  @US1525481
  Scenario: Optum ID sign on - Successful Login
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    Then user navigates to Onboarding self service page with given title "Provider Onboarding"
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

  @US1525481 @acceptance @smoke
  Scenario: Optum ID sign on - Unsuccessful Login
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | INVALID |
      | Password              | INVALID |
    Then I am displayed with an error message "The Optum ID or password that you entered is incorrect." on the page
