#Author: Pavan Narra
#Date: 07/29/2019
#Keywords Summary :
#Feature: US1867270 - Contract Page- Select Group for contract page
#List of scenarios:
# 1. Verify Contract page Controls
# 2. Verify Display list of groups
@F274632
Feature: US1867270 - Contract Page- Select Group for contract page
  
  As an Onboard Pro user, I need to select a group or groups that the provider will be linked to, 
  so that the provider can be contracted to my organization. 

  @US1867270 @regression
  Scenario Outline: Verify Contract Info Section
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can select the below Group and TIN
      | Group | <Group> |
      | TIN   | <TIN>   |
    When navigate to add provider modal with given title "ADD A NEW PROVIDER"
    And I enter add provider information
      | CAQHID | <CAQHID> |
    And I click Provider Check button
    And I click Continue
    When I click Continue on Cred decision page
    Then I am brought to the RFP page
    When I navigate to "Contract Info" via bubble navigation
    Then verify below controls on contract info section of RFP
      | Fields                      | TIN,ContractingGroup      |
      | Contract_Group_Default_Text | Select Contracting Groups |
      | Contracting_TIN             | <TIN>                     |
    Then user should be able to select below contracting groups
      | Contracting_Groups | <Contracting_Groups> |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | PRIMARY_PRACTICE_STATE | Group                 | TIN       | Contracting_Groups                                                                                                                                                                               							|
      | 16033555 | IN                     | WASHINGTON UNIVERSITY | 430653611 | WUSM PED PULMONARY,WUSM PED NEPHROLOGY,WUSM PED NEONATOLOGY,WUSM IM ONCOLOGY,WUSM IM CLINICAL NUTRITION,WUSM PEDI ANES,WASH U DEPT OF RHEUMATOLOGY,WUCA GRANT MEDICAL,WUSM IM CARDIOLOGY,WUSM OTOLARYNGOLOGY	|
