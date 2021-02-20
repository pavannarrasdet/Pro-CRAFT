#Author: B Salim Basha
#Date: 08/29/2019
#Keywords Summary :
#Feature: US1902710 - Cred required (Limited response from cred decision) message and next steps
#List of scenarios:
# 1. Verify Cred Response is Limited and next steps

@F243630
Feature: US1902710 - Cred required (Limited response from cred decision) message and next steps
  
		As an Onboard Pro User, I need to see a message displayed on the Onboard  Pro site if credentialing is or is not required, 
	so that I know what my next steps are to add the provider to my organization.   
 
  @US1902710 @regression
  Scenario Outline: Verify Cred Response is Limited and next steps
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
    
    Examples: 
    	| CAQHID   | CREDMessage                                                       | CAQHMessage                                                                      | TIN       | Group                        |
      | 16035124 | Based on the information provided, credentialing is required for: | We are now transferring some of your information from CAQH into our request form | 860767800 | ARIZONA COMMUNITY PHYSICIANS |
      