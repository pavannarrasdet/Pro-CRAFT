#Author: Pavan Narra
#Keywords Summary :
#Feature: US1525431 - CAQH ID and data validation
#List of scenarios:
# 1. Verify CAQH Error prones
@F243637
Feature: US1525431 - CAQH ID and data validation
  
  As a provider onboarding self service user, I need to enter in the CAQH ID of the provider
  I am adding to my organization, so that UHC can use that information to credentialing and
  contract the provider.

  @US1525431 @regression
  Scenario: Validate CAQH Error Prones
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can select the below Group and TIN
      | Group | WASHINGTON UNIVERSITY |
      | TIN   |             430653611 |
    And navigate to add provider modal with given title "ADD A NEW PROVIDER"
    Then perform CAQH field validations as below
      | Validation1              | entryOfCAQHId                        |
      | Validation2              | entryOfAlphabets                     |
      | Validation3              | entryOfAlphaNumeric                  |
      | Validation4              | entryOfNumericWithSpecailChar        |
      | Validation5              | entryOfMaxLength                     |
      | Validation6              | chracterLimitNotReached              |
      | CAQH_Limit_Error_Message | CAQH ID must be 8 numeric characters |
      | CAQHID                   | Random                               |
      | CAQHID_Char_Length       |                                    8 |
    And I click x button
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.
