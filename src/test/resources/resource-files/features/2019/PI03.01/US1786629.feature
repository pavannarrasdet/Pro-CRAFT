 #Author: Pavan Narra
#Date: 07/12/2019
#Keywords Summary :
#Feature:US1786614 - Pre fill provider License information
#List of scenarios:
# 1. Verify prepopulated State license info fields
# 2. Verify prepopulated DEA license info fields
# 3. Verify prepopulated CDS license info fields
# 4. Verify prepopulated Medicare license info fields
# 5. Verify prepopulated Medicaid license info fields
@F243634
Feature: US1786629 - Pre fill provider License information
  
  As a onboarding self service user, I need a page to enter in data about the provider that is joining my organization, so that UHC can receive and process my request.

  @US1786629 @regression
  Scenario Outline: Verify Pre-populated State license fields on RFP
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
    When I navigate to "Licenses" via bubble navigation
    And I can see pre-populated license fields as mentioned below
      | LicenseType    | <LicenseType>    |
      | State          | <State>          |
      | LicenseNumber  | <LicenseNumber>  |
      | IssueDate      | <IssueDate>      |
      | ExpirationDate | <ExpirationDate> |
      | UniqueValue    | <LicenseNumber>  |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | LicenseType   | State | LicenseNumber | IssueDate  | ExpirationDate |
      | 16000490 | State License | IN    |    1234568905 | 03/09/2018	| 12/31/2019     |


  @US1786629 @regression
  Scenario Outline: Verify Pre-populated DEA license fields on RFP
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
    When I navigate to "Licenses" via bubble navigation
    And I can see pre-populated license fields as mentioned below
      | LicenseType    | <LicenseType>    |
      | State          | <State>          |
      | LicenseNumber  | <LicenseNumber>  |
      | IssueDate      | <IssueDate>      |
      | ExpirationDate | <ExpirationDate> |
      | UniqueValue    | <ExpirationDate> |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | LicenseType | State | LicenseNumber | IssueDate  | ExpirationDate |
      | 16000490 | Federal DEA | IL    | we2367901     | 03/09/2017	| 03/04/2018     |


  @US1786629 @regression
  Scenario Outline: Verify Pre-populated CDS license fields on RFP
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
    When I navigate to "Licenses" via bubble navigation
    And I can see pre-populated license fields as mentioned below
      | LicenseType    | <LicenseType>    |
      | State          | <State>          |
      | LicenseNumber  | <LicenseNumber>  |
      | IssueDate      | <IssueDate>      |
      | ExpirationDate | <ExpirationDate> |
      | UniqueValue    | <LicenseType>    |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | LicenseType | State | LicenseNumber | IssueDate  | ExpirationDate |
      | 16000490 | CDS         | IL    |        123456 | 03/09/2017	| 03/04/2018     |

  @US1786629 @acceptance
  Scenario Outline: Verify Pre-populated Medicare license fields on RFP
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
    When I navigate to "Licenses" via bubble navigation
    And I can see pre-populated license fields as mentioned below
      | LicenseType    | <LicenseType>    |
      | State          | <State>          |
      | LicenseNumber  | <LicenseNumber>  |
      | IssueDate      | <IssueDate>      |
      | ExpirationDate | <ExpirationDate> |
      | UniqueValue    | <LicenseType>    |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | LicenseType | State | LicenseNumber | IssueDate | ExpirationDate |
      | 16000490 | Medicare    | IL    |    1234567890 | N/A       | N/A            |

  @US1786629 @acceptance
  Scenario Outline: Verify Pre-populated Medicaid license fields on RFP
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
    When I navigate to "Licenses" via bubble navigation
    And I can see pre-populated license fields as mentioned below
      | LicenseType    | <LicenseType>    |
      | State          | <State>          |
      | LicenseNumber  | <LicenseNumber>  |
      | IssueDate      | <IssueDate>      |
      | ExpirationDate | <ExpirationDate> |
      | UniqueValue    | <LicenseType>    |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | LicenseType | State | LicenseNumber | IssueDate | ExpirationDate |
      | 16000490 | Medicaid    | N/A   |    1234567890 | N/A       | N/A            |

