#Author: Pavan Narra
#Date: 07/25/2019
#Keywords Summary :
#Feature: US1786622 - Prompt user to enter Address Locations
#List of scenarios:
# 1. Verify Address Controls
# 2. Verify Order of the address table
@F274632
Feature: US1786622 - Prompt user to enter Address Locations
  
  As an Onboard Pro user, I need to enter in the address information of the provider 
  who is joining my organization, so that UHC can load the addresses to the provider 
  record to display for members to review.

  @US1786622 @regression
  Scenario Outline: Verify Address Grid and Controls
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can select the below Group and TIN
      | Group | WASHINGTON UNIVERSITY |
      | TIN   |             430653611 |
    And navigate to add provider modal with given title "ADD A NEW PROVIDER"
    And I enter add provider information
      | CAQHID | <CAQHID> |
    And I click Provider Check button
    And I click Continue
    When I click Continue on Cred decision page
    Then I am brought to the RFP page
    When I navigate to "Locations" via bubble navigation
    Then the primary practice state dropdown field should be auto-filled and disabled"<PRIMARY_PRACTICE_STATE>"
    Then verify below controls on locations section of RFP
      | Locations_Main_Heading | Please provide a current service, billing, and credentialling address associated to this Tax Indentification Number. |
      | Locations_Sub_Heading  | Current Locations:                                                                                                   |
      | Headers                | Type,Street Address,City,State,Zip,Phone,Fax,Actions                                                                 |
      | Cells                  | Billing,Place of Service,Credentialing                                                                               |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | PRIMARY_PRACTICE_STATE |
      | 16033555 | IN                     |
