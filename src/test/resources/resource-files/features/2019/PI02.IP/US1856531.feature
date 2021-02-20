#Author: Chandana Ganpule
#Date: 06/19/2019
#Keywords Summary :
#Feature: Self Service Request for Participation form
#List of scenarios:
#1. Verify all the fields on the add provider modal
#2. VErify that the fields are disabled except the CAQH field
@F243634
Feature: US1856531 - Provider Pre- RFP 2.0

  # This covers 1st scenario
  @US1856531 @regression 
  Scenario: Verify Provider Pre- RFP 2.0
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can select the below Group and TIN
      | Group | WASHINGTON UNIVERSITY |
      | TIN   |             430653611 |
    And navigate to add provider modal with given title "ADD A NEW PROVIDER"
    Then I can see the following elements
      | Input-Elements | First Name, Last Name, Middle Name, NPI,CAQH ID, Specialty, Practice Setting, Degree, Practice Setting State |
      | Btn-Elements   | Cancel, Continue                                                                                             |
      | Icon-Elements  | Practice Setting Tool tip                                                                                    |
      | Messages       | Pre- Credentialing Check message, CAQH ID Message                                                            |
    And I click x button
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

  #This covers 2nd scenario
  @US1856531 @regression
  Scenario: Verify Provider Pre- RFP 2.0
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can select the below Group and TIN
      | Group | WASHINGTON UNIVERSITY |
      | TIN   |             430653611 |
    And navigate to add provider modal with given title "ADD A NEW PROVIDER"
    Then only the CAQH ID field is active for entry
    And I click x button
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.
