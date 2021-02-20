#Author: Chandana
#Summary: This feature file is to navigate to Add provider modal- Populate provider data fields in the dashboard page
#Feature: Add provider modal- Populate provider data fields in the dashboard page
#List of Scenarios
#1. Populate Provider Name
#2. Populate Provider Specialty
#3. Populate Provider NPI
#4. Populate Request Created
#5. Populate Take Action button
#6. Verify the landing page with mongoDB records
@F243634
Feature: US1741008 - Add provider modal- Populate provider data fields in the dashboard page
  #This covers 1 to 6  scenarios listed above
  @US1741008 
   Scenario Outline: To verify the record is displayed on the dashboard page on clicking x
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
    Examples:
      | CAQHID   | NPI        | LastName | FirstName | MiddleName | ZipCode | PracticeSetting | Specialty      | CREDMessage                                                           | CAQHMessage                                                                      |
      | 16032635 | 1234567893 | BATES    | PATRICIA  | ABC         | 07920   | Inpatient Only  | Anesthesiology | Based on the information provided, credentialing is not required for: | We are now transferring some of your information from CAQH into our request form |

#This covers 1 to 6  scenarios listed above
  @US1741008
  Scenario Outline: To verify the record is displayed on the dashboard page on clicking cancel button
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
   And I click cancel button 
   Then I see the record displayed
   	| LastName        | <LastName>        |
    | FirstName       | <FirstName>       |
    | MiddleName      | <MiddleName>      |
    | NPI             | <NPI>             |
    | Specialty       | <Specialty>       |
    Examples:
    | CAQHID   | NPI        | LastName | FirstName | MiddleName | ZipCode | PracticeSetting      | Specialty          | CREDMessage                                                       | CAQHMessage                                                                      |
    | 16032635 | 1234567893 | Doe      | John      | DMG         | 07920   | Outpatient Only      | Addiction Medicine | Based on the information provided, credentialing is required for: | We are now transferring some of your information from CAQH into our request form |
   