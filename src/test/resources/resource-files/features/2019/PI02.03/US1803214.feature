#Author: Pavan Narra
#Date: 05/29/2019
#Keywords Summary :
#Feature:Onboarding Pro- Log out of site
#List of scenarios:
# 1. Verify Logout functionality

@F243634
Feature: US1803214- Onboarding Pro- Log out of site
  
  As an Onboarding Pro user, I need the ability to log out of the website so that information I have entered on the website remains secure. 

  @US1803214
  Scenario: Verify Logout functionality
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.
