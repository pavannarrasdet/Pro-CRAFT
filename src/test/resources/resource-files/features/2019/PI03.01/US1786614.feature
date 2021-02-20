#Author: Pavan Narra
#Date: 07/09/2019
#Keywords Summary :
#Feature:US1786614 - Pre-fill Practitioner Page
#List of scenarios:
# 1. Verify prepopulated practioner info fields
@F243634
Feature: US1786614 - Pre-fill Practitioner Page
  
  As a onboarding self service user, I need a page to enter in data about the provider that is joining my organization, so that UHC can receive and process my request.

  @US1786614 @regression
  Scenario Outline: Verify Pre-populate pract info fields on RFP
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
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | NPI        | LastName | FirstName  | MiddleName | Specialty                  | Degree | DateOfBirth | Suffix | Gender | BoardCertified | ExpirationDate |
      | 16032636 | 1164883963 | Clark    | Bernadette |            | Nurse Practitioner, Family | ASN    | 07/18/1973  |        | Female | Yes            | 06/16/2021     |

