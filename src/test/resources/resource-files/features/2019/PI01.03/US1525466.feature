#Author: Pavan Narra
#Keywords Summary :
#Feature: US1525466 - Onboarding Dashboard landing page
#List of scenarios:
# 1. Verify Landing Page Information
#@F243637
#Feature: US1525466 - Onboarding Dashboard landing page  
#  As a Onboarding self-service user, upon successful entry of my Optum ID,
#  I need to land on the onboarding dashboard page, so that I can view the options and
#  information available to me within the application.
#  @US1525466 @smoke
#  Scenario: Verify Landing Page Information
#    Given I have logged into Optum ID portal with given user name and password
#      | OptumIDoremailaddress | EXTERNAL |
#      | Password              | EXTERNAL |
#    When I navigate to Onboarding self service page with given title "Provider Onboarding"
#    Then I can see the following information on Landing page
#      | HEADER_INFORMATION   | HEADER_INFORMATION   |
#      | RIBBON_INFORMATION   | RIBBON_INFORMATION   |
#      | GREY_BAR_INFORMATION | GREY_BAR_INFORMATION |
#      | DASHBOARD_SECTION    | DASHBOARD_SECTION    |
#    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.