#Author: Pavan Narra
#Date: 09/03/2019
#Keywords Summary :
#Feature: US1856569 -  Display Success Message and Confirmation number
#List of scenarios:
# 1. Verify Add button
# 2. Verify Success Message
# 3. Verify Confirmation number
# 4. Verify Close/Cancel window
# 5. Verify display of most recent record ( as part of this US , this scenario is not covered as there is a cahnge in
#functionality in upcoming user story for this scenario, the same can be covered there)
@F274632
Feature: US1856569 - Display Success Message and Confirmation number
  
  As an Onboard Pro User, I want to receive a confirmation message and be provided with my Tracking ID after I have submitted my application, 
  so that I know my application has been accepted and have an ID where I can perform follow-up
  
  Assumptions:
  The 'successful' submission will be that the Integration Layer has received the request, as it may take some time for the actual application to be created in Salesforce and we do not want to have a poor provider experience.
  The Tracking ID will have been generated and already associated for the application upon its initial submission into the Integration Layer seeking the Cred Req Decision and this ID will remain the identifier for the work object regardless of its location. 

  #this covers #1 to 4
  @US1856569 @regression
  Scenario Outline: Verify Confirmation Number
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
    When I Attest the modal with below data
      | Attestor_Name | AUTO |
    Then I must see success message with confirmation number
      | ATTEST_SUCCESS_MSG | A Request for Participation form has been successfully submitted for |
      | PROVIDER_NAME      | <providerName>                                                       |
    When I close the attest modal
    Then I am brought to the dashboard page
    #Then I must see the practitioner record on status tracker page at top
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | SuperVising_LastName | SuperVising_FirstName | SuperVising_NPI | SuperVising_Specialty | Group                        | TIN       | Name                       | Privileges | AdmittingProvider      | LastNameAdmitting | FirstNameAdmitting | MiddleNameAdmitting | NPIAdmitting | SpecialityAdmitting | Contracting_Groups              | providerName      |
      | 16032636 | Peter                | James                 |      1013919851 | Addiction Medicine    | WASHINGTON UNIVERSITY				 | 430653611 | Beacon Children's Hospital | Temporary  | Provider Info Required | Peter             | James              | A                   |   1013919851 | Addiction Medicine  | WUSM IM ONCOLOGY,WUSM PEDI ANES | Bernadette  Clark |
