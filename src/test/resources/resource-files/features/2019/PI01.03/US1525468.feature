#Author: Pavan Narra
#Keywords Summary :
#Feature: US1525468 - Add provider button on dashboard page
#List of scenarios:
# 1.Verify Add provider modal controls existence
@F243637
Feature: US1525468 - Add provider button on dashboard page
  
  As a onboarding self service user, I need to have an add provider button available
  on the onboarding self service application, so that I can add a provider to be contracted
  with UHC under my organization.

  @US1525468 @regression
  Scenario: Verify Add provider modal controls existence
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can select the below Group and TIN
      | Group |WASHINGTON UNIVERSITY |
      | TIN   |            430653611 |
    And navigate to add provider modal with given title "ADD A NEW PROVIDER"
    Then I can see the following elements
      | Input-Elements    | First Name, Last Name, Middle Name, NPI, Primary Practice Zip Code |
      | Dropdown-Elements | Specialty, Practice Setting                                        |
      | Btn-Elements      | Cancel, Continue                                                   |
      | Icon-Elements     | Close , CAQH Tool tip , Practice Setting Tool tip                  |
    And I click x button
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.