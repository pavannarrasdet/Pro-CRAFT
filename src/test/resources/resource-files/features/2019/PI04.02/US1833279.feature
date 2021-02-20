#Author: Salim Basha
#Date: 09/26/2019
#Keywords Summary :
#Feature: US1833279 -  Cred not allowed message and next steps
#List of scenarios:
# 1. Verify Cred not allowed and message displayed
# 2. Verify system does not generate a CR
# 3. Verify credentialing decision information in DB

@F347889
Feature: US1833279 -  Cred not allowed message and next steps
  
As an Onboard Pro user, I need to see a message when the credentialing is not allowed, so that I know what my next steps are to credential the provider.

  @US1833279 @acceptance
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
   	Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.
   	
   	Examples: 
      | CAQHID   	|	Group                 | TIN       |	CREDNotAllowedMessage																																				|	CREDNotAllowedCallUsInfo												|	CREDNotAllowedPhoneNum	|
      | 16035146	|	WASHINGTON UNIVERSITY | 430653611 |	Based on the information, this provider is not eligible to participate in the network until |	To reach a representative, please call us at		|	877-842-3210 						|