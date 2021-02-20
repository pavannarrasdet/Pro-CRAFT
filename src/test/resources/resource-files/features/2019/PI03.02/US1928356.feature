#Author: Pratik Mistry
#Date: 07/24/2019
#Keywords Summary :
#Feature:US1928356 - Display message on Attachment page
#List of scenarios:
# 1. Verify info message will be dispaly on Attachment page
@F274632
Feature: US1928356 - Display message on Attachment page
  
  As a onboarding self service user, I need a page to enter in data about the provider that is joining my organization, so that UHC can receive and process my request.

  @US1928356 @regression
  Scenario Outline: Verify Pre-populate pract info fields on RFP
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
    When I navigate to "Attachments" via bubble navigation
    Then I can see the below attachment information message
      | Attachments        | Attachments          |
      | AttachmentsMessage | <AttachmentsMessage> |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | CAQHID   | AttachmentsMessage                                                                                                                                                 | Group                 | TIN       |
      | 16032635 | All required documents will be pulled from CAQH upon submission of the RFP Form.If any issues are discovered, the submitter of this form will be contacted by UHC. |	WASHINGTON UNIVERSITY | 430653611 |