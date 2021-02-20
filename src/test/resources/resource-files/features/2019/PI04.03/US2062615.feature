#Author: Srinivas T
#Date: 10/18/2019
#Keywords Summary :
#Feature: US2062615 - Add Practice Start date to contract page- cred required and not required
#List of scenarios:
# 1. Verify Practice start date- contract page- cred required
# 2. Verify Practice start date- contract page- cred not required
# 3. Verify Submit button- not active
# 4. Verify Submit button- Active

@F347910
Feature: US2062615 - Add Practice Start date to contract page- cred required and not required

  @US2062615 @regression 
    Scenario Outline: Verify Add Practice Start date to contract page- cred required
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
    Then Verify "Practitioner Info" section and populate missing fields
      | SuperVising_LastName  | <SuperVising_LastName>  |
      | SuperVising_FirstName | <SuperVising_FirstName> |
      | SuperVising_Specialty | <SuperVising_Specialty> |
      | SuperVising_NPI       | <SuperVising_NPI>       |
    Then Verify "Locations" section and populate missing fields
      | RFP_LocationType   | Billing                                |
      | LocationType       | Billing,Place Of Service,Credentialing |
      | StreetAddress      | TestStreetAddress                      |
      | City               | TestCity                               |
      | State              | IN                                     |
      | ZipCode            |                                  36677 |
      | Phone              | 989-333-6019                           |
      | Fax                | 987-333-6019                           |
      | ADD_Location_Title | ADD A NEW LOCATION                     |
    Then Verify "Hospital Affiliation" section and populate missing fields
      | Name                | <Name>                |
      | Privileges          | <Privileges>          |
      | AdmittingProvider   | <AdmittingProvider>   |
      | LastNameAdmitting   | <LastNameAdmitting>   |
      | FirstNameAdmitting  | <FirstNameAdmitting>  |
      | MiddleNameAdmitting | <MiddleNameAdmitting> |
      | SpecialityAdmitting | <SpecialityAdmitting> |
      | NPIAdmitting        | <NPIAdmitting>        |
    Then Verify "Contract Info" section and populate missing fields
      | Contracting_Groups | <Contracting_Groups> |
    And Verify if SubmitRFP is enabled for "valid" date
     | Valid_Date  | <Valid_Date>  |
    And Verify if SubmitRFP is not enabled for "invalid" date
     | InValid_Date| <InValid_Date>|
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | SuperVising_LastName | SuperVising_FirstName | SuperVising_NPI | SuperVising_Specialty | Group                   | TIN       | Name                       | Privileges | AdmittingProvider      | LastNameAdmitting | FirstNameAdmitting | MiddleNameAdmitting | NPIAdmitting | SpecialityAdmitting | Contracting_Groups              |Valid_Date|InValid_Date|
      | 16032636 | Peter                | James                 |      1013919851 | Addiction Medicine    | WASHINGTON UNIVERSITY		| 430653611 | Beacon Children's Hospital | Temporary  | Provider Info Required | Peter             | James              | A                   |   1013919851 | Addiction Medicine  | WUSM IM ONCOLOGY,WUSM PEDI ANES |10/17/2019|23/23/2019	 |
   
    @US2062615 @regression @acceptance 
  Scenario Outline: Verify Add Practice Start date to contract page- cred not required
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
    Then Verify "Practitioner Info" section and populate missing fields
      | SuperVising_LastName  | <SuperVising_LastName>  |
      | SuperVising_FirstName | <SuperVising_FirstName> |
      | SuperVising_Specialty | <SuperVising_Specialty> |
      | SuperVising_NPI       | <SuperVising_NPI>       |
    Then Verify "Locations" section and populate missing fields
      | RFP_LocationType   | Billing                                |
      | LocationType       | Billing,Place Of Service,Credentialing |
      | StreetAddress      | TestStreetAddress                      |
      | City               | TestCity                               |
      | State              | IN                                     |
      | ZipCode            |                                  36677 |
      | Phone              | 989-333-6019                           |
      | Fax                | 987-333-6019                           |
      | ADD_Location_Title | ADD A NEW LOCATION                     |
    Then Verify "Contract Info" section and populate missing fields
      | Contracting_Groups | <Contracting_Groups> |
    And Verify if SubmitRFP is enabled for "valid" date
     | Valid_Date  | <Valid_Date>  |
    And Verify if SubmitRFP is not enabled for "invalid" date
     | InValid_Date| <InValid_Date>|
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | SuperVising_LastName | SuperVising_FirstName | SuperVising_NPI | SuperVising_Specialty | Group                 | TIN       | Contracting_Groups                | providerName         | CREDMessage                                                           | CAQHMessage                                                                      |Valid_Date|InValid_Date|
      | 16035078 | Peter                | James                 |      1013919851 | Addiction Medicine    | WASHINGTON UNIVERSITY | 430653611 | WUSM PATHOLOGY,WUSM IM CARDIOLOGY | bbxorhov a. ftsaauls | Based on the information provided, credentialing is not required for: | We are now transferring some of your information from CAQH into our request form |10/17/2019|23/23/2019	|
  