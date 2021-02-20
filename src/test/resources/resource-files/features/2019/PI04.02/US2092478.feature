#Author: Srinivas T
#Date: 10/04/2019
#Keywords Summary :
#Feature: US2092478 - Cred Entity Behavioral Health Status tracker
#List of scenarios:
# 1. Verify Display Provider record in Onboard Pro status tracker
# 2. Verify Tracker fields for Optum Behavioral Health
# 3. Verify hyperlink contact Optum behavioral health
# 4. Verify go to site button functionality

@F347889
Feature: US2092478 - Cred Entity Behavioral Health Status tracker

  @US2092478 @regression
    Scenario Outline: Verify the Cred Entity Behavioral Health Status tracker
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
    And I click on close button after verifying ContactusLink
    | ContactMessageLink | <ContactMessageLink> |
		Then I can see below data fields on provider record that is linked to Optum Behavioral Health decision 
		|PROVIDER_NAME			 |<PROVIDER_NAME>  		  |
		|NPI			  				 |<NPI>					   		  |
		|SPECIALITY			 		 |<SPECIALITY>	   		  |
		|CONTACTUS_NUMBER		 |<CONTACTUS_NUMBER>		|
		Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.
		
 Examples: 
      | CAQHID   | PROVIDER_NAME			 |NPI						 |SPECIALITY						 |ContactMessageLink									  |CONTACTUS_NUMBER|
      | 16035864 | xhtruryx j. fmbzndij|1841345246|Podiatrist, General Practice|Please contact Optum Behavioral Health|877-614-0484		 |
 
 