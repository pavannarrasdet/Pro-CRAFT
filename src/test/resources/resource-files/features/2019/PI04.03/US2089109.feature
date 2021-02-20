#Author: Salim Basha
#Date: 10/22/2019
#Keywords Summary :
#Feature: US2089109 - Edit Address - Location
#List of scenarios:
# 1. Verify Add view/edit button
# 2. Verify Add pencil icon when an address is successfully added to address table
# 3. Verify Click on View/Edit icon
# 4. Verify Edit fields in modal of previously added address
# 5. Verify updated information in table after edit

@F347910
Feature: US2089109 - Edit Address - Location
  
  As an Onboard Pro user, I need the ability to edit the addresses I entered  on the locations page, so I can ensure the the correct address information is submitted as part of my request.
	
	#This covers scenario 1 when credentialing is required 
  @US2089109 @acceptance
  Scenario Outline: Verify Add view/edit button
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
    
    #This covers from scenario 2 to 5 when credentialing is required
    @US2089109 @acceptance
    Scenario Outline: Verify Add pencil icon when an address is successfully added to address table
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
    Then Adding the below address into the modal
      | StreetAddress      | TestStreetAddress                      |
      | City               | TestCity                               |
      | State              | IN                                     |
      | ZipCode            |                                  36677 |
      | Phone              | 989-333-6019                           |
      | Fax                | 987-333-6019                           |
      | ADD_Location_Title | ADD A NEW LOCATION                     |
    And Verify pencil icon when an address is successfully added
    	| RFP_LocationType   | <LocationType>     |
    When I navigate to Edit Location Page
      | RFP_LocationType   	| <LocationType>    |
      | EDIT_Location_Title | EDIT LOCATION	 		|
    Then I verify the existing address in the modal
    	| RFP_LocationType   | <LocationType>     										|
    	| StreetAddress      | TestStreetAddress                      |
      | City               | TestCity                               |
      | State              | IN                                     |
      | ZipCode            |                                  36677 |
      | Phone              | 989-333-6019                           |
      | Fax                | 987-333-6019                           |
      | EDIT_Location_Title| EDIT LOCATION                     			|
    Then I update below information and save locations data
      | StreetAddress      				| UpdatedTestStreetAddress               |
      | City               				| UpdatedTestCity                        |
      | State              				| NJ                                     |
      | ZipCode            				|                                  07097 |
      | Phone              				| 973-348-1000                           |
      | Fax                				| 987-333-1000                           |
      | EDIT_Location_Title				| EDIT LOCATION                     		 |
 		And I verify the updated address in the modal
 			| RFP_LocationType   				| <LocationType>     									   |
      | UpdatedStreetAddress      | UpdatedTestStreetAddress               |
      | UpdatedCity               | UpdatedTestCity                        |
      | UpdatedState              | NJ                                     |
      | UpdatedZipCode            |                                  07097 |
      | UpdatedPhone              | 973-348-1000                           |
      | UpdatedFax                | 987-333-1000                           |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.
    
     Examples: 
      | CAQHID   | TIN       | Group                 | LocationType     | PRIMARY_PRACTICE_STATE |
      | 16033555 | 430653611 | WASHINGTON UNIVERSITY | Billing          | IN                     |
      | 16033555 | 430653611 | WASHINGTON UNIVERSITY | Place of Service | IN                     |
      | 16033555 | 430653611 | WASHINGTON UNIVERSITY | Credentialing    | IN                     |
    
    #This covers scenario 1 when credentialing is not required
    @US2089109 @acceptance
  	Scenario Outline: Verify Add view/edit button
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
      | 16035078 | IN                     |
    
    #This covers from scenario 2 to 5 when credentialing is not required
    @US2089109 @acceptance
    Scenario Outline: Verify Add pencil icon when an address is successfully added to address table
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
    Then Adding the below address into the modal
      | StreetAddress      | TestStreetAddress                      |
      | City               | TestCity                               |
      | State              | IN                                     |
      | ZipCode            |                                  36677 |
      | Phone              | 989-333-6019                           |
      | Fax                | 987-333-6019                           |
      | ADD_Location_Title | ADD A NEW LOCATION                     |
    And Verify pencil icon when an address is successfully added
    	| RFP_LocationType   | <LocationType>     |
    When I navigate to Edit Location Page
      | RFP_LocationType   	| <LocationType>    |
      | EDIT_Location_Title | EDIT LOCATION	 		|
    Then I verify the existing address in the modal
    	| RFP_LocationType   | <LocationType>     										|
    	| StreetAddress      | TestStreetAddress                      |
      | City               | TestCity                               |
      | State              | IN                                     |
      | ZipCode            |                                  36677 |
      | Phone              | 989-333-6019                           |
      | Fax                | 987-333-6019                           |
      | EDIT_Location_Title| EDIT LOCATION                     			|
    Then I update below information and save locations data
      | StreetAddress      				| UpdatedTestStreetAddress               |
      | City               				| UpdatedTestCity                        |
      | State              				| NJ                                     |
      | ZipCode            				|                                  07097 |
      | Phone              				| 973-348-1000                           |
      | Fax                				| 987-333-1000                           |
      | EDIT_Location_Title				| EDIT LOCATION                     		 |
 		And I verify the updated address in the modal
 			| RFP_LocationType   				| <LocationType>     									   |
      | UpdatedStreetAddress      | UpdatedTestStreetAddress               |
      | UpdatedCity               | UpdatedTestCity                        |
      | UpdatedState              | NJ                                     |
      | UpdatedZipCode            |                                  07097 |
      | UpdatedPhone              | 973-348-1000                           |
      | UpdatedFax                | 987-333-1000                           |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.
    
     Examples: 
      | CAQHID   | TIN       | Group                 | LocationType     | PRIMARY_PRACTICE_STATE |
      | 16035078 | 430653611 | WASHINGTON UNIVERSITY | Billing          | IN                     |
      | 16035078 | 430653611 | WASHINGTON UNIVERSITY | Place of Service | IN                     |
      | 16035078 | 430653611 | WASHINGTON UNIVERSITY | Credentialing    | IN                     |
    