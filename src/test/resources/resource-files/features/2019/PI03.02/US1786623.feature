#Feature: US1786623 - Pre-Fill Provider Hospital Affiliations Page
#List of scenarios:
# 1. Verify Pre Populate Hospital Affiliation fields- single Hospital
# 2. Verify Pre-populate Hospital Affiliation-More than one Hospital 
# 3. Verify display error info for temporary privilege
# 4. Verify display error info for limited privilege
# 5. Edit icon red when privilege is temporary or limited
# 6. Verify click edit button- show modal fields
# 7. Verify Admitting First Name Validation - numeric character
# 8. Verify Admitting First Name Validation - 20 characters non numeric
# 9. Validation of Admitting first name alpha numeric
# 10. Validation of First name- alpha with special characters
# 11. Validation of First name- alpha with numeric and special characters
# 12. Admitting Last Name Validation
# 13. Admitting Last Name Validation - 40 characters
# 14. Admitting Last name alpha/numeric combo
# 15. Admitting last name alpha/special char combo
# 16. Admitting last name alpha/numeric/special char
# 17. Admitting Middle Name Validation - Numeric character
# 18. Admitting Middle Name Validation - 20 characters
# 19. Admitting middle name- alpha/numeric combo
# 20. Admitting Middle name- alpha/special char combo
# 21. Admitting Middle name- alpha/numeric/special char
# 22. Entry of Admitting NPI
# 23. Validation of NPI (Alpha character edit)
# 24. Validation of NPI (Special character edit)
# 25. Validation of NPI (Character Limit reached)
# 26. Validation of NPI (Character Limit not reached)
# 27. Validation of NPI (Luhn digit check fails)
# 28. Verify Add button active
# 29. Verify Cancel Button
# 30. Verification of display admitting physician info after clicking save
@F274632
Feature: US1786623 - Pre-Fill Provider Hospital Affiliations Page
  
  As an Onboard Pro user, I need the data fields on the Hospital Affiliations page Pre-filled with the Hospital Affiliation info from the providers CAQH ID.

  # This Outline covers from 1 and 5
  @US1786623 @regression
  Scenario Outline: Verify Pre-populated Hospital Affiliation fields on RFP
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
    When I click Continue on Cred decision page
    Then I am brought to the RFP page
    When I navigate to "Hospital Affiliation" via bubble navigation
    And I can see pre-populated Hospital Affiliation records as mentioned below
      | Name              | <Name>              |
      | Privileges        | <Privileges>        |
      | AdmittingProvider | <AdmittingProvider> |

    Examples: 
      | CAQHID   | Name                         | Privileges            | AdmittingProvider      | Group                 | TIN       |
      | 16033555 | Alaska Psychiatric Institute | Full And Unrestricted | N/A                    | WASHINGTON UNIVERSITY | 430653611 |
      | 16032636 | Beacon Children's Hospital   | Temporary             | Provider Info Required | WASHINGTON UNIVERSITY | 430653611 |

  # This Outline covers 6
  @US1786623 @regression
  Scenario Outline: Verify edit button- show modal fields
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
    When I click Continue on Cred decision page
    Then I am brought to the RFP page
    When I navigate to "Hospital Affiliation" via bubble navigation
    And I can see pre-populated Hospital Affiliation records as mentioned below
      | Name              | <Name>              |
      | Privileges        | <Privileges>        |
      | AdmittingProvider | <AdmittingProvider> |
    When I navigate to edit affiliated hospital modal with given title "EDIT HOSPITAL"
      | Name              | <Name>              |
      | Privileges        | <Privileges>        |
      | AdmittingProvider | <AdmittingProvider> |
    And verify Edit Hospital Modal fields
      | Fields | Last Name(Admitting),First Name(Admitting),Middle Name(Admitting),Speciality(Admitting),NPI(Admitting) |

    Examples: 
      | CAQHID   | Name                       | Privileges | AdmittingProvider      | Group                 | TIN       |
      | 16032636 | Beacon Children's Hospital | Temporary  | Provider Info Required | WASHINGTON UNIVERSITY | 430653611 |

  # This Outline covers from 7 and 30
  @US1786623 @regression
  Scenario Outline: Verification & Validation of Edit Hospital Affiliatio Fields
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
    When I click Continue on Cred decision page
    Then I am brought to the RFP page
    When I navigate to "Hospital Affiliation" via bubble navigation
    And I can see pre-populated Hospital Affiliation records as mentioned below
      | Name              | <Name>              |
      | Privileges        | <Privileges>        |
      | AdmittingProvider | <AdmittingProvider> |
    When I navigate to edit affiliated hospital modal with given title "EDIT HOSPITAL"
      | Name              | <Name>              |
      | Privileges        | <Privileges>        |
      | AdmittingProvider | <AdmittingProvider> |
    Then perform edit admitting provider name fields validations as below
      | Validation1            | entryOfName                          |
      | Validation2            | entryOfNumericCharacters             |
      | Validation3            | entryOfAlphaNumericCharacters        |
      | Validation4            | entryOfAlphaSpecialCharacters        |
      | Validation5            | entryOfAlphaNumericSpecialCharacters |
      | Validation6            | entryOfMaxLength                     |
      | LastNameAdmitting      | <LastName>                           |
      | LastName_Char_Length   |                                   40 |
      | FirstNameAdmitting     | <FirstName>                          |
      | FirstName_Char_Length  |                                   20 |
      | MiddleNameAdmitting    | <MiddleName>                         |
      | MiddleName_Char_Length |                                   20 |
    Then perform edit admitting provider npi fields validations as below
      | Validation1     | entryOfNPI                                |
      | Validation2     | entryOfAlphabets                          |
      | Validation3     | entryOfAlphaNumeric                       |
      | Validation4     | entryOfNumericWithSpecailChar             |
      | Validation5     | entryOfMaxLength                          |
      | Validation6     | chracterLimitNotReached                   |
      | NPIAdmitting    | <NPI>                                     |
      | NPI_Char_Length |                                        10 |
      | NPI_Len_Err     | NPI must be 10 numeric characters         |
      | NPI_Luhn_Err    | NPI entered is not valid. Please re-enter |
    When I update below information and cancel the edit hsp afl modal
      | LastNameAdmitting   | TESTUPDATELNMEADMITING |
      | FirstNameAdmitting  | TESTUPDATEFNMEADMITI   |
      | MiddleNameAdmitting | TESTUPDATEMNMEADMITI   |
      | SpecialityAdmitting | <Specialty>            |
      | NPIAdmitting        | <NPI>                  |
    Then I can not see updated affiliations details as mentioned below
      | AdmittingProvider | TESTUPDATEFNMEADMITI T. TESTUPDATELNMEADMITING |
    When I navigate to edit affiliated hospital modal with given title "EDIT HOSPITAL"
      | Name              | <Name>              |
      | Privileges        | <Privileges>        |
      | AdmittingProvider | <AdmittingProvider> |
    When I update below information and save hospital affiliation data
      | LastNameAdmitting   | <LastName>   |
      | FirstNameAdmitting  | <FirstName>  |
      | MiddleNameAdmitting | <MiddleName> |
      | SpecialityAdmitting | <Specialty>  |
      | NPIAdmitting        |   1013919851 |
    Then I can see updated hospital affiliations details as mentioned below
      | Privileges        | Temporary      |
      | AdmittingProvider | James A. Peter |

    Examples: 
      | CAQHID   | Name                       | Privileges | AdmittingProvider      | LastName | FirstName | MiddleName | NPI        | Specialty          | Group                 | TIN       |
      | 16032636 | Beacon Children's Hospital | Temporary  | Provider Info Required | Peter    | James     | A          | 1234567893 | Addiction Medicine | WASHINGTON UNIVERSITY | 430653611 |
