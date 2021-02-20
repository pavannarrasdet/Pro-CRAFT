#Author: Pavan Narra
#Keywords Summary :
#Feature: US1525443 - Display Credentialing Response to user
#List of scenarios:
# 1. To verify the credentialing not required message
# 2. To verify the credentialing required message
@F243637
Feature: US1525443 - Display Credentialing Response to user
  
  As a onboarding self service user, I need to view  a message after i click continue on the add provider modal, so that I know whether or not the provider requires credentialing or not.

  @US1525443
  Scenario Outline: To verify the credentialing not required message
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
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | CREDMessage                                                           | CAQHMessage                                                                      |
      | 16032635 | Based on the information provided, credentialing is not required for: | We are now transferring some of your information from CAQH into our request form |
      | 16032635 | Based on the information provided, credentialing is not required for: | We are now transferring some of your information from CAQH into our request form |

  @US1525443
  Scenario Outline: To verify the credentialing required message
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
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | CREDMessage                                                       | CAQHMessage                                                                      |
      | 16032635 | Based on the information provided, credentialing is required for: | We are now transferring some of your information from CAQH into our request form |
      | 16032635 | Based on the information provided, credentialing is required for: | We are now transferring some of your information from CAQH into our request form |
