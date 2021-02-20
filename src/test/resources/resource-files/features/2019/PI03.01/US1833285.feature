#Author: Salim Basha
#Date: 07/04/2019
#Feature: US1833285 - Cred required message and next steps
#List of Scenarios
#1. Verify Cred Required decision message on Onboard Pro site
@F243630
Feature: US1833285 - Cred required message and next steps
  
  As an Onboard Pro User, I need to see a message displayed on the Onboard  Pro site if credentialing is or is not required

  @US1833285 @regression
  Scenario Outline: To verify the credentialing is required message
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can select the below Group and TIN
      | Group | ARIZONA COMMUNITY PHYSICIANS |
      | TIN   |                    860767800 |
    And navigate to add provider modal with given title "ADD A NEW PROVIDER"
    And I enter add provider information
      | CAQHID | <CAQHID> |
    And I click Provider Check button
    And I click Continue
    Then I am displayed below message
      | CREDMessage | <CREDMessage> |
      | CAQHMessage | <CAQHMessage> |
    When I click Cancel on Cred decision page

    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | CREDMessage                                                       | CAQHMessage                                                                      |
      | 16000981 | Based on the information provided, credentialing is required for: | We are now transferring some of your information from CAQH into our request form |
      | 16032636 | Based on the information provided, credentialing is required for: | We are now transferring some of your information from CAQH into our request form |
