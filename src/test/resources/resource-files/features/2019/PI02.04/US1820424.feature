#Author: Chandana
#Summary: Next Steps and RFP
#Feature: Self Service Request For Participation (RFP) form
#List of Scenarios
#1. Click Next steps and verify the RFP page
@F243634
Feature: US1820424 - Next Steps and RFP
  #This covers 1st scenario
  @US1820424
   Scenario Outline: To verify the RFP page is displayed with auto-populated fields from the dashboard page on clicking x
   Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    And navigate to add provider modal with given title "ADD A NEW PROVIDER"
    And I enter add provider information
      | LastName        | <LastName>        |
      | FirstName       | <FirstName>       |
      | MiddleName      | <MiddleName>      |
      | CAQHID          | <CAQHID>          |
      | NPI             | <NPI>             |
      | Specialty       | <Specialty>       |
      | PracticeSetting | <PracticeSetting> |
      | ZipCode         | <ZipCode>         |
    And I click Continue
    Then I am displayed below message
      | CREDMessage | <CREDMessage> |
      | CAQHMessage | <CAQHMessage> |
   And I click x button
   Then I see the record displayed
   	| LastName        | <LastName>        |
    | FirstName       | <FirstName>       |
    | MiddleName      | <MiddleName>      |
    | NPI             | <NPI>             |
    | Specialty       | <Specialty>       |
   And I click Next Steps button
   Then I am brought to the RFP page
   And I can see the following fields pre-populated
      | LastName        | <LastName>        |
      | FirstName       | <FirstName>       |
      | MiddleName      | <MiddleName>      |
      | CAQHID          | <CAQHID>          |
      | NPI             | <NPI>             |
      | Specialty       | <Specialty>       |
    Examples:
      | CAQHID   | NPI        | LastName | FirstName | MiddleName | ZipCode | PracticeSetting | Specialty       | CREDMessage                                                           | CAQHMessage                                                                      |
      | 16032635 | 1234567893 | BATES    | PATRICIA  | ABC         | 07920   | Inpatient Only  | Anesthesiology | Based on the information provided, credentialing is not required for: | We are now transferring some of your information from CAQH into our request form |