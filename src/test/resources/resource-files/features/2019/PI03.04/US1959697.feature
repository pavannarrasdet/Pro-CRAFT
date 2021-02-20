#Author: Pavan Narra
#Date: 08/19/2019
#Keywords Summary :
#Feature: US1959697 - Display Review & Confirmation page
#List of scenarios:
# 1. Verify Review/Attest modal controls
# 2. Verify Attestor name
# 3. Verify Change Attestors Name
# 4. Verify Attestor Name text box Char length - 1 to 120
# 5. Verify Attestor Name Char text box validation
# 6. Verify here by checkbox
# 7. Verify continue and cancel button
@F274632
Feature: US1959697 - Display Review & Confirmation page
  
  As an Onboard Pro User, I want to view a review and confirmation page after i have clicked the submit RFP button, 
  so that I can review the information that will be submitted to UHC to load the provider to my organization.

  #this covers #1 to 7
  @US1959697 @regression
  Scenario Outline: Verify Attestation
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
    When I Submit RFP form
    Then I must navigate to Acknowledgement window
      | Ack_Title | ACKNOWLEDGE AND SUBMIT |
    Then I can perform below validations
      | FIELDS_CHK            | I_HERE_CHK_BOX,CANCEL_BTN,ADD_BTN,ATTESTOR_NAME_TXT                                                                                                                                                                                                                                                                               |
      | Validation2           | entryOfNumericCharacters                                                                                                                                                                                                                                                                                                          |
      | Validation3           | entryOfAlphaNumericCharacters                                                                                                                                                                                                                                                                                                     |
      | Validation4           | entryOfAlphaSpecialCharacters                                                                                                                                                                                                                                                                                                     |
      | Validation5           | entryOfAlphaNumericSpecialCharacters                                                                                                                                                                                                                                                                                              |
      | Validation6           | entryOfMaxLength                                                                                                                                                                                                                                                                                                                  |
      | Attestor_Char_Len     |                                                                                                                                                                                                                                                                                                                               120 |
      | INFO_ATTEST_MSG       | Upon attestation below, all sections of the application (RFP) will be submitted for                                                                                                                                                                                                                                               |
      | USER_CONFIRM_ATST_MSG | I hereby attest that all of the information above is true and accurate to the best of my knowledge, I understand that any information provided pursuant to this attestation that is subsequently found to be untrue and/or incorrect could result in the care provider applicant's termination from the UnitedHealthcare network. |
      | PROVIDER_NAME         | <providerName>                                                                                                                                                                                                                                                                                                                    |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | SuperVising_LastName | SuperVising_FirstName | SuperVising_NPI | SuperVising_Specialty | Group                   | TIN       | Name                       | Privileges | AdmittingProvider      | LastNameAdmitting | FirstNameAdmitting | MiddleNameAdmitting | NPIAdmitting | SpecialityAdmitting | Contracting_Groups              | providerName      |
      | 16032636 | Peter                | James                 |      1013919851 | Addiction Medicine    | WASHINGTON UNIVERSITY		| 430653611 | Beacon Children's Hospital | Temporary  | Provider Info Required | Peter             | James              | A                   |   1013919851 | Addiction Medicine  | WUSM IM ONCOLOGY,WUSM PEDI ANES | Bernadette  Clark |
