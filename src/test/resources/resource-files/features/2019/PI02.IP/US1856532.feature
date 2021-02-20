#Author: Pavan Narra
#Date: 06/27/2019
#Feature: US1856532 - Populate Pre-Credential modal fields with data from CAQH
#List of Scenarios
#1. Verify prepopulated data from CAQH on Add provider modal
#2. Verify Logic to display Inpatient only of Practice setting
#3. Verify Logic to display Inpatient/OutPatient  only of Practice setting - this has some data issue
@F243634
Feature: US1856532 - Populate Pre-Credential modal fields with data from CAQH
  
  As a Onboarding Self service user, the pre-credentialing check data fields pre-populated with data from CAQH,
   so that I do not have to manually enter in the fields.

  @US1856532 @regression
  Scenario Outline: Verify prepopulated data from CAQH on Add provider modal
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
    Then I must see the below fields prepoulated from CAQH
      | LastName                    | <LastName>                    |
      | FirstName                   | <FirstName>                   |
      | MiddleName                  | <MiddleName>                  |
      | NPI                         | <NPI>                         |
      | Specialty                   | <Specialty>                   |
      | Degree                      | <Degree>                      |
      | PracticeSetting             | <PracticeSetting>             |
      | PrimaryPracticeSettingState | <PrimaryPracticeSettingState> |
    And I click Continue
    When I click Continue on Cred decision page
    Then I am brought to the RFP page
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | NPI        | LastName | FirstName  | MiddleName | PracticeSetting      | Specialty           | Degree | PrimaryPracticeSettingState |
      | 16000981 | 1013919851 | WILCOX	 | WILLIAM    |            | Inpatient/Outpatient | Hospitalist         | MBBS   | NV                          |
      | 16032636 | 1164883963 | Clark    | Bernadette |            | Inpatient/Outpatient | Physician Assistant | ANP    | IN                          |
