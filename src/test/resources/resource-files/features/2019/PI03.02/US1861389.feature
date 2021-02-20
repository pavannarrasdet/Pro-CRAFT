#Author: Pavan Narra
#Date: 08/01/2019
#Keywords Summary :
#Feature: US1861389 - Prompt user to enter Address Locations
#List of scenarios:
# 1. Verify Add Location Modal - Billing
# 2. Verify Add Location Modal - PLSV
# 3. Verify Add Location Modal - Cred
# 4. Verify Cancelling Add Location Modal - Billing
# 5. Verify Cancelling Add Location Modal - PLSV
# 6. Verify Cancelling Add Location Modal - Cred
# 7. Verify Close Icon - Billing
# 8. Verify Close Icon - PLSV
# 9. Verify Close Icon - Cred
# 10. Verify Add Location - Billing ( out of scope for automation
# as there will be a upcoming feature to auto-fill the locations)
# 11. Verify Add Location - PLSV
# as there will be a upcoming feature to auto-fill the locations)
# 12. Verify Add Location - Cred
# as there will be a upcoming feature to auto-fill the locations)
@F274632
Feature: US1861389 - Present address modal and display in address grid
  
  As an Onboard Pro user, I need to enter in the address information of the provider
  who is joining my organization, so that UHC can load the addresses to the provider 
  record to display for members to review.

  @US1861389 @regression
  Scenario Outline: Verify address modal and display in address grid
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
    When I navigate to "Locations" via bubble navigation
    Then the primary practice state dropdown field should be auto-filled and disabled"<PRIMARY_PRACTICE_STATE>"
    When I navigate to Add Location Page
      | RFP_LocationType   | <LocationType>     |
      | ADD_Location_Title | ADD A NEW LOCATION |
    Then I can verify Add Location controls as mentioned below
      | Fields | LocationType,StrtAdr,City,State,ZipCode,Phone,Fax |
    When I close the Add location window
    Then I am brought to the RFP page
    When I navigate to Add Location Page
      | RFP_LocationType     	| <LocationType>     |
      | ADD_Location_Title 		| ADD A NEW LOCATION |
    When I cancel the Add location window
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | TIN       | Group                 | LocationType     | PRIMARY_PRACTICE_STATE |
      | 16032636 | 430653611 | WASHINGTON UNIVERSITY | Billing          | IN                     |
      | 16032636 | 430653611 | WASHINGTON UNIVERSITY | Place of Service | IN                     |
      | 16032636 | 430653611 | WASHINGTON UNIVERSITY | Credentialing    | IN                     |
