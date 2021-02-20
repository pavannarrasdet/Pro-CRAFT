#Author: Pavan Narra
#Date: 09/06/2019
#Keywords Summary :
#Feature: US1833896 -  Update Existing Tracker
#List of scenarios:
# 1. Verify RFP not submitted for Cred required
# 2. Verify RFP Submitted for Cred required
# 3. Verify RFP submitted through begin RFP for cred required
# Cred not required scenarios are covered as part of US1866279
# User should provide record type parameter as below for new records(case sensitive)
#New-Submitted,New-In-Completed
# User should provide record type as below for an existing record (case sensitive)
#Existing-Submitted,Existing-Completed,Existing-In-Completed,Existing-Denied,Existing-Closed
@F243630
Feature: US1833896 - Update Existing Tracker
  
  As an Onboard Pro User, I want to  view the status of my submissions, so I am able to track the progress UHC is making on my submission.

  @US1833896 @regression
  Scenario Outline: Verify RFP submitted for Cred required CAQH
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
    When I Submit RFP form
    Then I must navigate to Acknowledgement window
      | Ack_Title | ACKNOWLEDGE AND SUBMIT |
    When I Attest the modal with below data
      | Attestor_Name | AUTO |
    Then I must see success message with confirmation number
      | ATTEST_SUCCESS_MSG | A Request for Participation form has been successfully submitted for |
      | PROVIDER_NAME      | <providerName>                                                       |
    When I close the attest modal
    Then I am brought to the dashboard page
    Then I must see the practitioner record on status tracker page
      | PROVIDER_NAME      | <providerName>      |
      | NPI                |          1164883963 |
      | Specialty          | Physician Assistant |
      | RFP_Record_Type    | New-Submitted       |
      | CRED_Status        | Required            |
      | CR_NUMBER          | AUTO                |
      | RFP_SUBMITTED_DATE | AUTO                |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | SuperVising_LastName | SuperVising_FirstName | SuperVising_NPI | SuperVising_Specialty | Group                 | TIN       | Name                       | Privileges | AdmittingProvider      | LastNameAdmitting | FirstNameAdmitting | MiddleNameAdmitting | NPIAdmitting | SpecialityAdmitting | Contracting_Groups                | providerName      | CREDMessage                                                       | CAQHMessage                                                                      |
      | 16032636 | Peter                | James                 |      1013919851 | Addiction Medicine    | WASHINGTON UNIVERSITY | 430653611 | Beacon Children's Hospital | Temporary  | Provider Info Required | Peter             | James              | A                   |   1013919851 | Addiction Medicine  | WUSM PATHOLOGY,WUSM IM CARDIOLOGY | Bernadette  Clark | Based on the information provided, credentialing is required for: | We are now transferring some of your information from CAQH into our request form |

  @US1833896 @regression
  Scenario Outline: Verify RFP in-complete for Cred required CAQH
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
    When I click Cancel on Cred decision page
    Then I am brought to the dashboard page
    Then I must see the practitioner record on status tracker page
      | PROVIDER_NAME      | <providerName>      |
      | NPI                |          1164883963 |
      | Specialty          | Physician Assistant |
      | RFP_Record_Type    | New-In-Completed    |
      | CRED_Status        | Required            |
      | RFP_SUBMITTED_DATE | AUTO                |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | SuperVising_LastName | SuperVising_FirstName | SuperVising_NPI | SuperVising_Specialty | Group                 | TIN       | Name                       | Privileges | AdmittingProvider      | LastNameAdmitting | FirstNameAdmitting | MiddleNameAdmitting | NPIAdmitting | SpecialityAdmitting | Contracting_Groups                | providerName      | CREDMessage                                                       | CAQHMessage                                                                      |
      | 16032636 | Peter                | James                 |      1013919851 | Addiction Medicine    | WASHINGTON UNIVERSITY | 430653611 | Beacon Children's Hospital | Temporary  | Provider Info Required | Peter             | James              | A                   |   1013919851 | Addiction Medicine  | WUSM PATHOLOGY,WUSM IM CARDIOLOGY | Bernadette  Clark | Based on the information provided, credentialing is required for: | We are now transferring some of your information from CAQH into our request form |

  @US1833896 @regression
  Scenario Outline: Verify RFP submitted through begin RFP for Cred required CAQH
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
    When I click Cancel on Cred decision page
    Then I am brought to the dashboard page
    Then I must see the practitioner record on status tracker page
      | PROVIDER_NAME      | <providerName>      |
      | NPI                |          1164883963 |
      | Specialty          | Physician Assistant |
      | RFP_Record_Type    | New-In-Completed    |
      | CRED_Status        | Required            |
      | RFP_SUBMITTED_DATE | AUTO                |
    When I Begin RFP for an in-progress record as mentioned below
      | PROVIDER_NAME      | <providerName>      |
      | NPI                |          1164883963 |
      | Specialty          | Physician Assistant |
      | CRED_Status        | Required            |
      | RFP_SUBMITTED_DATE | AUTO                |
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
    When I Submit RFP form
    Then I must navigate to Acknowledgement window
      | Ack_Title | ACKNOWLEDGE AND SUBMIT |
    When I Attest the modal with below data
      | Attestor_Name | AUTO |
    Then I must see success message with confirmation number
      | ATTEST_SUCCESS_MSG | A Request for Participation form has been successfully submitted for |
      | PROVIDER_NAME      | <providerName>                                                       |
    When I close the attest modal
    Then I am brought to the dashboard page
    Then I must see the practitioner record on status tracker page
      | PROVIDER_NAME      | <providerName>      |
      | NPI                |          1164883963 |
      | Specialty          | Physician Assistant |
      | RFP_Record_Type    | New-Submitted       |
      | CRED_Status        | Required            |
      | CR_NUMBER          | AUTO                |
      | RFP_SUBMITTED_DATE | AUTO                |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | SuperVising_LastName | SuperVising_FirstName | SuperVising_NPI | SuperVising_Specialty | Group                 | TIN       | Name                       | Privileges | AdmittingProvider      | LastNameAdmitting | FirstNameAdmitting | MiddleNameAdmitting | NPIAdmitting | SpecialityAdmitting | Contracting_Groups                | providerName      | CREDMessage                                                       | CAQHMessage                                                                      |
      | 16032636 | Peter                | James                 |      1013919851 | Addiction Medicine    | WASHINGTON UNIVERSITY | 430653611 | Beacon Children's Hospital | Temporary  | Provider Info Required | Peter             | James              | A                   |   1013919851 | Addiction Medicine  | WUSM PATHOLOGY,WUSM IM CARDIOLOGY | Bernadette  Clark | Based on the information provided, credentialing is required for: | We are now transferring some of your information from CAQH into our request form |
