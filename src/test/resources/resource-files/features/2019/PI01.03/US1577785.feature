#Author: Chandana
#Keywords Summary :
#Feature:US1577785 - Execute CACF API
#List of scenarios:
# 1.Optum ID sign on
@F243640
Feature: US1577785 - Execute CACF API
  This feature will provide the ability to provision and grant access to external users (non UHG employees) to an enhanced self service digital provider onboarding application that will allow requests for providers to join UnitedHealthcare Networks.

  @US1577785 @smoke
  Scenario: Optum ID sign on
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    Then user navigates to Onboarding self service page with given title "Provider Onboarding"
    And user can see the associated organizations and tax ID
