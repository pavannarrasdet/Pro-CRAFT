#Author: Salim Basha
#Date: 07/19/2019
#Keywords Summary :
#Feature: US1893784 - Pre-fill Degree- updated logic
#List of scenarios:
# 1. Verify single degree in degree section - require CAQH ID to test this scenario
# 2. Verify more than one degree in degree section which are same - Show 1st Degree
# 3. Verify more than one degree in degree section which are different then we look at professional/Medical school
# 4. Verify more than one degree which are different then we look at professional school- use latest completion professional school date
# 5. Verify no degree value is populated in the degree field on pre-credentialing modal
@F274632
Feature: US1893784 - Pre-fill Degree- updated logic
  
  As an Onboard Pro user, I need the degree of the provider in CAQH pre-filled in the pre-cred modal.

  #This covers 2 to 4 scenario's
  @US1893784 @regression
  Scenario Outline: Verify Pre-Fill Degree Updated Logic
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can select the below Group and TIN
      | Group | <Group> |
      | TIN   | <TIN>   |
    And navigate to add provider modal with given title "ADD A NEW PROVIDER"
    And I enter add provider information
      | CAQHID | <CAQHID> |
    And I click Provider Check button
    Then I must see the degree field Pre-Populated from CAQH
      | Degree | <Degree> |
    And I click Continue
    When I click Continue on Cred decision page
    Then I am brought to the RFP page
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | Degree | Group                 | TIN       |
      | 16000981 | MBBS   | WASHINGTON UNIVERSITY | 430653611 |
      | 16032636 | ANP    | WASHINGTON UNIVERSITY | 430653611 |
      | 16000490 | CRNP   | WASHINGTON UNIVERSITY | 430653611 |

  #This covers scenario 5
  @US1893784 @regression
  Scenario Outline: Verify no degree value is populated in the degree field
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can select the below Group and TIN
      | Group | <Group> |
      | TIN   | <TIN>   |
    And navigate to add provider modal with given title "ADD A NEW PROVIDER"
    And I enter add provider information
      | CAQHID | <CAQHID> |
    And I click Provider Check button
    Then I must not see the degree field on provider modal
      | Degree | <Degree> |
    And I click Continue
    When I click Continue on Cred decision page
    Then I am brought to the RFP page
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | Degree | Group                 | TIN       |
      | 16032635 |        | WASHINGTON UNIVERSITY | 430653611 |
