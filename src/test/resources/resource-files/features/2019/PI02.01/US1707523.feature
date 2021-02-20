#Author: Chandana
#Keywords Summary :
#Feature:US1707523 - Add provider modal- Build template of dashboard page
#List of scenarios:
# 1.To verify the header elements on clicking x button
# 2.To verify the header elements on clicking cancel button
@F243634
Feature: US1707523 - Add provider modal- Build template of dashboard page
  
  As a onboarding self service user, I need to have a cancel button on the modal, so that i can continue with the process or cancel the information I've entered.
 
 # The below scenario is deprecated due to functionality
  @US1707523 @deprecated
  Scenario Outline: To verify the header elements on clicking x button
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
      #| CREDMessage | <CREDMessage> |
      | CAQHMessage | <CAQHMessage> |
    #And I click x button
    Then I see the below header elements
      | Provider Name             | Provider Name             |
      | Primary Practice Location | Primary Practice Location |
      | Request Created           | Request Created           |
      | Credentials Verified      | Credentials Verified      |
      | Contract Initiated        | Contract Initiated        |
      | Contract Finalized        | Contract Finalized        |
      | Take Action               | Take Action               |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | CREDMessage                                                           | CAQHMessage                                                                      |
      | 16032635 | Based on the information provided, credentialing is not required for: | We are now transferring some of your information from CAQH into our request form |

  @US1707523 @deprecated
  Scenario Outline: To verify the header elements on clicking cancel button
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
    And I click cancel button
    Then I see the below header elements
      | Provider Name             | Provider Name             |
      | Primary Practice Location | Primary Practice Location |
      | Request Created           | Request Created           |
      | Credentials Verified      | Credentials Verified      |
      | Contract Initiated        | Contract Initiated        |
      | Contract Finalized        | Contract Finalized        |
      | Take Action               | Take Action               |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | CREDMessage                                                       | CAQHMessage                                                                      |
      | 16032635 | Based on the information provided, credentialing is required for: | We are now transferring some of your information from CAQH into our request form |
