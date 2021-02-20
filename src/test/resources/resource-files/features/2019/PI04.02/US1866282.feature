#Author: Salim Basha
#Date: 10/04/2019
#Keywords Summary :
#Feature: US1866282 -  Cred not allowed status tracker
#List of scenarios:
# 1. Verify Provider record in Onboard Pro status tracker
# 2. Verify Tracker fields for Not allowed
# 3. Verify click contact us

@F347889
Feature: US1866282 -  Cred not allowed status tracker
  
As an Onboard Pro user, I need to see a message when the credentialing is not allowed, so that I know what my next steps are to credential the provider. 

  @US1866282 @acceptance
    Scenario Outline: Verify Cred not allowed and message displayed
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
    Then The Credentialing Decision service is Not Allowed
    	| CREDNotAllowedMessage 		| <CREDNotAllowedMessage> 	|
    	|	CREDNotAllowedCallUsInfo	|	<CREDNotAllowedCallUsInfo>|
    	|	CREDNotAllowedPhoneNum		|	<CREDNotAllowedPhoneNum>	|
    And I click close button
   	Then I am brought to the dashboard page
   	Then I must see the cred not allowed record on status tracker page
   		| PROVIDER_NAME      	| <PROVIDER_NAME>			|
      | NPI                	|        1528033487		|
      | Specialty          	| Internal Medicine		|
      |	REFERENCE_NUMBER		| <REFERENCE_NUMBER>	|
    Then I am brought to the ContactUs page
   	Then The following information is displayed in the modal
    	| CREDNotAllowedMessage 		| <CREDNotAllowedMessage> 	|
    	|	CREDNotAllowedCallUsInfo	|	<CREDNotAllowedCallUsInfo>|
    	|	CREDNotAllowedPhoneNum		|	<CREDNotAllowedPhoneNum>	|
    And I click close button on ContactUs page
   	Then I am brought to the dashboard page
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.
   	
   	Examples: 
      | CAQHID   	|	Group                 | TIN       |	CREDNotAllowedMessage																																				|	CREDNotAllowedCallUsInfo												|	CREDNotAllowedPhoneNum	|	PROVIDER_NAME					|	REFERENCE_NUMBER						|
      | 16035146	|	WASHINGTON UNIVERSITY | 430653611 |	Based on the information, this provider is not eligible to participate in the network until |	To reach a representative, please call us at		|	877-842-3210 						|	kztnivyy p. owujudsx	|	Ineligible until 10/09/2020	|
      