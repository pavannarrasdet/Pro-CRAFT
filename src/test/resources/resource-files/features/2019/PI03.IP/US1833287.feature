#Author: B Salim Basha
#Date: 09/03/2019
#Keywords Summary :
#Feature: US1833287 - Cred not required message and next steps
#List of scenarios:
# 1. Verify Cred Not required
# 2. Verify Save credentialing decision information in DB
# 3. Verify RFP sections

@F243630
Feature: US1833287 - Cred not required message and next steps
  
		As an Onboard Pro User, I need to see a message displayed on the Onboard  Pro site if credentialing is or is not required, so that I know what my next steps are to add the provider to my organization. 
	
	#This covers scenario 1 and secnario 3 with Mid-Level Supervising
	#CAQH ID - 16035078 is meeting requirement of mid level supervising. So, if any changes it  may impact the test case execution
  
  @US1833287 @regression
  Scenario Outline: Verify Cred not required message and next steps
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
    And I click Continue
    Then I am displayed below message
      | CREDMessage | <CREDMessage> |
      | CAQHMessage | <CAQHMessage> |
    When I click Continue on Cred decision page
    Then I am brought to the RFP page
    And I can see all practitioner fields must be pre-populated and readonly
      | LastName       | <LastName>       |
      | FirstName      | <FirstName>      |
      | MiddleName     | <MiddleName>     |
      | NPI            | <NPI>            |
      | Specialty      | <Specialty>      |
      | Degree         | <Degree>         |
      | Suffix         | <Suffix>         |
      | Gender         | <Gender>         |
      | BoardCertified | <BoardCertified> |
      | DateOfBirth    | <DateOfBirth>    |
      | CAQHID         | <CAQHID>         |
      | ExpirationDate | <ExpirationDate> |
    And I can see the following supervising physician fields if request supervising physician is True
      | Fields | LNAME(Supervising),FNAME(Supervising),SPCLTY(Supervising),NPI(Supervising) |
    Then I enter below information
      | SuperVising_LastName  | <LastName>  |
      | SuperVising_FirstName | <FirstName> |
      | SuperVising_Specialty | <Specialty> |
      | SuperVising_NPI       | <NPI>       |
    When I navigate to "Locations" via bubble navigation
    Then the primary practice state dropdown field should be auto-filled and disabled"<PRIMARY_PRACTICE_STATE>"
    Then verify below controls on locations section of RFP
      | Locations_Main_Heading | Please provide a current service, billing, and credentialling address associated to this Tax Indentification Number. |
      | Locations_Sub_Heading  | Current Locations:                                                                                                   |
      | Headers                | Type,Street Address,City,State,Zip,Phone,Fax,Actions		|
      | Cells                  | Billing,Place of Service,Credentialing									|
    When I navigate to "Contract Info" via bubble navigation
    Then verify below controls on contract info section of RFP
      | Fields                      | TIN,ContractingGroup      |
      | Contract_Group_Default_Text | Select Contracting Groups |
      | Contracting_TIN             | <TIN>                     |
    Then user should be able to select below contracting groups
      | Contracting_Groups | <Contracting_Groups> |
   	Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.
    
    Examples: 
    	| CAQHID   | CREDMessage                                                       		| CAQHMessage                                                                      | TIN       | Group                        |	NPI       	| LastName	| FirstName | MiddleName| Specialty					| Degree	| DateOfBirth | Suffix	| Gender	| BoardCertified	| ExpirationDate	|	PRIMARY_PRACTICE_STATE	|					Contracting_Groups																																																																																													|
      | 16035078 | Based on the information provided, credentialing is not required for:| We are now transferring some of your information from CAQH into our request form | 430653611 | WASHINGTON UNIVERSITY				|	1649408030 	|	ftsaauls	|	bbxorhov	|	aavjelpi	|	Nurse Practitioner|	ACSW		|	09/08/1947	|	II			|	Male		|	No							|									|	IN											|				WUSM PED PULMONARY,WUSM PED NEPHROLOGY,WUSM PED NEONATOLOGY,WUSM IM ONCOLOGY,WUSM IM CLINICAL NUTRITION,WUSM PEDI ANES,WASH U DEPT OF RHEUMATOLOGY,WUCA GRANT MEDICAL,WUSM IM CARDIOLOGY,WUSM OTOLARYNGOLOGY	|
    
    #This scenario covers 1 and 3 without Mid-Level Supervising
    @US1833287 @regression
  Scenario Outline: Verify Cred not required message and next steps
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
    And I click Continue
    Then I am displayed below message
      | CREDMessage | <CREDMessage> |
      | CAQHMessage | <CAQHMessage> |
    When I click Continue on Cred decision page
    Then I am brought to the RFP page
    And I can see all practitioner fields must be pre-populated and readonly
      | LastName       | <LastName>       |
      | FirstName      | <FirstName>      |
      | MiddleName     | <MiddleName>     |
      | NPI            | <NPI>            |
      | Specialty      | <Specialty>      |
      | Degree         | <Degree>         |
      | Suffix         | <Suffix>         |
      | Gender         | <Gender>         |
      | BoardCertified | <BoardCertified> |
      | DateOfBirth    | <DateOfBirth>    |
      | CAQHID         | <CAQHID>         |
      | ExpirationDate | <ExpirationDate> |
    When I navigate to "Locations" via bubble navigation
    Then the primary practice state dropdown field should be auto-filled and disabled"<PRIMARY_PRACTICE_STATE>"
    Then verify below controls on locations section of RFP
      | Locations_Main_Heading | Please provide a current service, billing, and credentialling address associated to this Tax Indentification Number. |
      | Locations_Sub_Heading  | Current Locations:                                                                                                   |
      | Headers                | Type,Street Address,City,State,Zip,Phone,Fax,Actions		|
      | Cells                  | Billing,Place of Service,Credentialing									|
    When I navigate to "Contract Info" via bubble navigation
    Then verify below controls on contract info section of RFP
      | Fields                      | TIN,ContractingGroup      |
      | Contract_Group_Default_Text | Select Contracting Groups |
      | Contracting_TIN             | <TIN>                     |
    Then user should be able to select below contracting groups
      | Contracting_Groups | <Contracting_Groups> |  
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.
    
    Examples: 
    	| CAQHID   | CREDMessage                                                       		| CAQHMessage                                                                      | TIN       | Group                        |	NPI       	| LastName	| FirstName | MiddleName| Specialty					| Degree	| DateOfBirth | Suffix	| Gender	| BoardCertified	| ExpirationDate	|	PRIMARY_PRACTICE_STATE	|					Contracting_Groups																																																																																													|
      | 16035144 | Based on the information provided, credentialing is not required for:| We are now transferring some of your information from CAQH into our request form | 430653611 | WASHINGTON UNIVERSITY				|	1922009109 	|	SHIRRELL	|	KAREN			|						|	Internal Medicine	|	MDDO		|	07/21/1987	|					|	Female	|	Yes							|	03/25/2024			|	IN											|				WUSM PED PULMONARY,WUSM PED NEPHROLOGY,WUSM PED NEONATOLOGY,WUSM IM ONCOLOGY,WUSM IM CLINICAL NUTRITION,WUSM PEDI ANES,WASH U DEPT OF RHEUMATOLOGY,WUCA GRANT MEDICAL,WUSM IM CARDIOLOGY,WUSM OTOLARYNGOLOGY	|
    