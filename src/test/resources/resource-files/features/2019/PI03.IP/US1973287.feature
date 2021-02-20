#Author: B Salim Basha
#Date: 09/06/2019
#Keywords Summary :
#Feature: US1973287 - Implement Logic for Other CAQH Statuses
#List of scenarios:
# 1. Verify CAQH status First Provider Contact


@F243630
Feature: US1973287 - Implement Logic for Other CAQH Statuses
  
		As an Onboard Pro User, I need to see a message displayed to me and next steps in the Onboard Pro system when the status of my CAQH is not in re-attestation status, so that I can navigate to CAQH and make updates to continue the application.   
 
  @US1973287 @regression
  Scenario Outline: Verify CAQH status First Provider Contact
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
   	Then I am displayed with CAQH application is not Complete message
   	| CAQH_Application_Incomplete_Err_Msg 		| <CAQHApplicationIncompleteErrMsg> 		|
    | CAQH_Application_Incomplete_Header_Msg  | <CAQHApplicationIncompleteHeaderMsg> 	|
   	
   	Examples:
   	| CAQHID   	| TIN       | Group                        |	CAQHApplicationIncompleteHeaderMsg	| CAQHApplicationIncompleteErrMsg																																																																			|
   	|	16034764	|	860767800 | ARIZONA COMMUNITY PHYSICIANS |	CAQH application is not Complete		|	Based on the CAQH ID entered, CAQH is reviewing your application.  Upon notification of completed application from CAQH, you will be able to continue your request.	|
   	|	16034762	|	860767800 | ARIZONA COMMUNITY PHYSICIANS |	CAQH application is not Complete		|	Based on the CAQH ID entered, CAQH is reviewing your application.  Upon notification of completed application from CAQH, you will be able to continue your request.	|
   	|	16034758	|	860767800 | ARIZONA COMMUNITY PHYSICIANS |	CAQH application is not Complete		|	Based on the CAQH ID entered, CAQH is reviewing your application.  Upon notification of completed application from CAQH, you will be able to continue your request.	|
   	|	16034763	|	860767800 | ARIZONA COMMUNITY PHYSICIANS |	CAQH application is not Complete		|	Based on the CAQH ID entered, CAQH is reviewing your application.  Upon notification of completed application from CAQH, you will be able to continue your request.	|
   	|	16034756	|	860767800 | ARIZONA COMMUNITY PHYSICIANS |	CAQH application is not Complete		|	Based on the CAQH ID entered, CAQH is reviewing your application.  Upon notification of completed application from CAQH, you will be able to continue your request.	|