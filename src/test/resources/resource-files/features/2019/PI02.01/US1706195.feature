#Author: Pavan Narra
#Keywords Summary :
#Feature:US1706195 - RFP Page layout & provider info
#List of scenarios:
# 1.Optum ID sign on
@F243634
Feature: RFP Page layout & provider info - US1706195
  As a onboarding self service user, I need a page to enter in data about the provider that is joining my organization, so that UHC can receive and process my request.

  @US1706195 @smoke
  Scenario Outline: Verify RFP page controls and prepoulated data
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
    And I click Continue on Cred decision page
    Then I am brought to the RFP page
    Then I can see the following information on RFP page
      | HEADER_INFORMATION   | HEADER_INFORMATION   |
      | RIBBON_INFORMATION   | RIBBON_INFORMATION   |
      | GREY_BAR_INFORMATION | GREY_BAR_INFORMATION |
      | LastName             | <LastName>           |
      | FirstName            | <FirstName>          |
      | MiddleName           | <MiddleName>         |
      | CAQHID               | <CAQHID>             |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | FirstName  | MiddleName | LastName |
      | 16032635 | Susan      | Sally      | Boyle    |
      | 16032636 | Bernadette |            | Clark    |
