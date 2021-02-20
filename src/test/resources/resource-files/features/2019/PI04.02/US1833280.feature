#Author: Srinivas T
#Date: 10/03/2019
#Keywords Summary :
#Feature: US1833280 - Cred Entity Behavioral Health Message and next steps
#List of scenarios:
# 1. Verify Cred Entity is Behavioral Health message
# 2. Verify URL for Behavioral health message on cred decision modal

@F347889
Feature: US1833280 - Cred Entity Behavioral Health Message and next steps

  @US1833280 @regression
    Scenario Outline: Verify Cred Entity Behavioral Health Message and next steps
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
    Then I am displayed below Behavioral Health Message Information
      | BehavioralHealthMessage 		 | <BehavioralHealthMessage> |
      | ContactMessageLink           | <ContactMessageLink> 		 |
      | ContactMessageNumber         | <ContactMessageNumber> 	 |
		Then I verify the Optum Behavioral link
		And I click x button
		Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.
		
 Examples: 
      | CAQHID   | BehavioralHealthMessage                                                      																				    | ContactMessageLink  								   | ContactMessageNumber|    
      | 16035864 | Based on the information provided, credentialing for this care provider needs to be completed by a separate department.  | Please contact Optum Behavioral Health | 877-614-0484				 |
