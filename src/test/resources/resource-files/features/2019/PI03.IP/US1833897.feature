#Author: Pavan Narra
#Date: 09/20/2019
#Keywords Summary :
#Feature: US1833897 -  Update Status tracker logic
#List of scenarios:
# 1. Verify Display status/home page- Optum ID is multiple group/tin
# 2. Verify show add provider button after group/tin is selected
# out of scope:
# Display status/home page- Optum ID is single group/tin : Automation optum id doesnt has single tin & group so its out of scope
#Display status/home page- Optum ID is multiple group/TIN
# Verifying existed records belongs to specific tin/group scenarios are out of scope as
# we can't maintain the records on pro UI everytime as sometimes we might have to delete the records per optum id & tin to improve the performance
# Need to do some analysis till then out of scope
#Application in progress view
# a.Verifying the headers/columns scenarios are already covered in US1833896
@F243630
Feature: US1833897 - Update Status tracker logic
  
  As a Developer, I want to have a table which will help to determine what message or status icon should be displayed to the User when he/she is either viewing the status tracker or hovers over a status, so that the User can clearly identify the status of a request and is able to see an explanation as to what that status means.
  
  Assumptions:
  The translations of values from Salesforce to Onboard Pro will be handled by the Integration Layer.
  There will be instances where an 'application' may be closed because no credentialing is required or the application is just not completed and time has elapsed which the application will be archived.
  The 'Application' statuses will be managed by the Integration Layer, as Salesforce has not yet received the request and therefore unable to provide any status.
  
  
  Note- this story only accommodate draft application, application in progress, and approved credentialing.  Separate story will be created for closed/denied/terminated

	#Add provider info text works if 000000001/CORSO PAUL does not has any existing RFP records
  @US1833897 @regression
  Scenario Outline: Verify Dashboard page state before and after Grp/Tin selection
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then I must see below information text on dashboard page
      | DashBrd_Selct_Grp_TIN_Txt | <DashBrd_Deflt_Txt> |
    Then user can select the below Group and TIN
      | Group | <Group> |
      | TIN   | <TIN>   |
    Then I must see add provider info on dashboard page
      | DashBrd_Add_Prv_Btn_Info_Txt | <Add_Prv_Info_Txt> |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | Group      | TIN       | DashBrd_Deflt_Txt                                                                                      | Add_Prv_Info_Txt                                                   |
      | CORSO PAUL | 000000001 | To get started, select a group and then select a Tax ID Number (TIN) from the drop down options above. | Add a new provider by clicking on the 'Add Provider' button below. |