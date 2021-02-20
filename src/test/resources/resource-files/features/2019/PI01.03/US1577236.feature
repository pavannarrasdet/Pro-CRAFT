@F243637
Feature: CAQH ID Provider not found, authorization, and attestation messaging - US1577236
  
  As a onboarding self service user, I a message displayed on the self service application when the there are errors from the CAQH search, so I can understand what the error is and make any necessary corrections.

  @US1577236
  Scenario Outline: To verify the CAQH messages for provider not found , not attested and not authorized
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can select the below Group and TIN
      | Group | ARIZONA COMMUNITY PHYSICIANS |
      | TIN   |                    860767800 |
    And navigate to add provider modal with given title "ADD A NEW PROVIDER"
    And I enter add provider information
      | CAQHID | <CAQHID> |
    And I click Provider Check button
    Then I am displayed with provider not found error messages
      | CAQH_Provider_Not_Found         | <ProviderNotFoundErrMsg>    |
      | CAQH_Provider_Not_Found_Hdr_Msg | <ProviderNotFoundHeaderMsg> |

    #Attestation & Authorization scenarions are on hold per my discussion with Jeff as these 2 error messages are depends on external system (CAQH Demo)
    #Once automation has dedicated test data for each specific automated test then we can uncomment
    # And I enter add provider information
    #  | CAQHID | Test data needed |
    #And I click Continue
    #Then I am displayed with below attestation CAQH error messages
    # | CAQH_Attestation_Expired    | <AttestationExpiredErrMsg> |
    #| CAQH_Attestation_Header_Msg | <AttestationHeaderMsg>     |
    # And I enter add provider information
    #   | CAQHID | 16032636 |
    # And I click Continue
    #Then I am displayed with CAQH auth required error messages
    #   | CAQH_Authorization_Req_Err_Msg | <AuthorizationReqErrMsg> |
    # | CAQH_Authorization_Header_Msg  | <AuthorizationHeaderMsg> |
    # And I enter add provider information
    #   | CAQHID | 16032636 |
    # And I click Continue
    #Then I am displayed with CAQH auth and attest required error messages
    #| CAQH_Authorization_Attestation_Req_Err_Msg | <AuthorizationReqAndAttestionErrMsg> |
    #| CAQH_Authorization_Attestation_Header_Msg  | <AuthorizationAndAttestaionHeaderMsg> |
    Examples: 
      | CAQHID   | NPI        | LastName | FirstName | MiddleName | ZipCode | PracticeSetting | Specialty      | ProviderNotFoundErrMsg                                                                                                             | AttestationExpiredErrMsg                                                                                                                                                                            | AuthorizationReqErrMsg                                                                                                                                                                                                                         | AttestationHeaderMsg         | AuthorizationHeaderMsg | ProviderNotFoundHeaderMsg | CAQH_Authorization_Attestation_Req_Err_Msg                                                                                                                                                                                                           | CAQH_Authorization_Attestation_Header_Msg |
      | 99999999 | 1234567893 | BATES    | PATRICIA  | A.         |   07920 | Inpatient Only  | Anesthesiology | Based on the CAQH ID entered, we were unable to locate your information in the CAQH database, please try to re-enter your CAQH ID. | Based on the CAQH ID you entered, you have not attested to the data in your CAQH account.  In order to proceed with your request, please log into your CAQH account and attest to your information. | Based on the CAQH ID you entered, you have not authorized UnitedHealthcare to use your data from your CAQH account.  In order to proceed with your request, please log into your CAQH account and authorize UnitedHealthcare to use your data. | Attestation Required in CAQH | CAQH ID Not Authorized | Provider Not Found        | Based on the CAQH ID you entered, the data in your account has not been attested to or authorized for use by UnitedHealthcare. In order to proceed with your request, please log into your CAQH account to authorize and attest to your information. | CAQH ID Not Authorized or Attested        |
