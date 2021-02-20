#Author: B Salim Basha
#Date: 08/06/2019
#Keywords Summary :
#Feature: US1856694 - Prompt for Supervising Physician info for Mid Level
#List of scenarios:
# 1. Verify Present Supervising physician fields
# 2. Verify Enter Supervising physician  first name fields 
# 3. Verify Enter Supervising physician  Last name fields
# 4. Verify Enter Supervising physician specialty
# 5. Verify Enter Supervising physician NPI
# 6. Verify Submit RFP button
# 7. Verify Supervising First Name Validation - numeric character
# 8. Verify Supervising First Name Validation - 20 characters non numeric
# 9. Validation of Supervising first name alpha numeric
# 10. Validation of First name- alpha with special characters
# 11. Validation of First name- alpha with numeric and special characters
# 12. Verify Supervising Last Name Validation- numeric char validation
# 13. Verify Supervising Last Name Validation- char length
# 14. Verify Supervising Last name alpha/numeric combo
# 15. Verify Supervising last name alpha/special char combo
# 16. Verify Supervising last name alpha/numeric/special char
@F274632
Feature: US1856694 - Prompt for Supervising Physician info for Mid Level
  
  As an Onboard Pro user, I need to provide the Supervising Physician information when the provider I'm adding is a mid-level specialty, so that request I will submit contains all necessary information for UHC to process my request. 

  # This scenario covers 1 to 17 expect 6
  @US1856694 @regression
  Scenario Outline: Verify Prompt for Supervising Physician info for Mid Level
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
    And I can see the following supervising physician fields if request supervising physician is True
      | Fields | LNAME(Supervising),FNAME(Supervising),SPCLTY(Supervising),NPI(Supervising) |
    Then perform supervising physician name fields validation as below
      | Validation1                       | entryOfName                          |
      | Validation2                       | entryOfNumericCharacters             |
      | Validation3                       | entryOfAlphaNumericCharacters        |
      | Validation4                       | entryOfAlphaSpecialCharacters        |
      | Validation5                       | entryOfAlphaNumericSpecialCharacters |
      | Validation6                       | entryOfMaxLength                     |
      | LastNameAdmitting                 | <LastName>                           |
      | SuperVising_LastName_Char_Length  |                                   40 |
      | FirstNameAdmitting                | <FirstName>                          |
      | SuperVising_FirstName_Char_Length |                                   20 |
    Then perform supervising physician npi field validations as below
      | Validation1                 | entryOfNPI                                |
      | Validation2                 | entryOfAlphabets                          |
      | Validation3                 | entryOfAlphaNumeric                       |
      | Validation4                 | entryOfNumericWithSpecailChar             |
      | Validation5                 | entryOfMaxLength                          |
      | Validation6                 | chracterLimitNotReached                   |
      | NPIAdmitting                | <NPI>                                     |
      | SuperVising_NPI_Char_Length |                                        10 |
      | SuperVising_NPI_Len_Err     | NPI must be 10 numeric characters         |
      | SuperVising_NPI_Luhn_Err    | NPI entered is not valid. Please re-enter |

    Examples: 
      | CAQHID   | LastName | FirstName | MiddleName | NPI        | Specialty          | Group                 | TIN       |
      | 16032636 | Peter    | James     | A          | 1234567893 | Addiction Medicine | WASHINGTON UNIVERSITY | 430653611 |

  #This covers scenario 6
  @US1856694 @regression
  Scenario Outline: Entering Supervising Physician info for Mid Level
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
    Then I enter below information
      | SuperVising_LastName  | <LastName>  |
      | SuperVising_FirstName | <FirstName> |
      | SuperVising_Specialty | <Specialty> |
      | SuperVising_NPI       | <NPI>       |

    Examples: 
      | CAQHID   | LastName | FirstName | MiddleName | NPI        | Specialty          | Group                 | TIN       |
      | 16032636 | Peter    | James     | A          | 1013919851 | Addiction Medicine | WASHINGTON UNIVERSITY | 430653611 |
