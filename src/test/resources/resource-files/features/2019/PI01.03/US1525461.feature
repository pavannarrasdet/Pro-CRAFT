#Author: Chandana
#Keywords Summary :
#Feature: US1525461 - Implement Ribbon on RPF self service application
#List of scenarios:
# 1. Implement Ribbon - Default Group Value
# 2. Implement Ribbon -  Access to Multiple Groups & Single TIN , SSN TIN
@F243637
Feature: US1525461 - Implement Ribbon on RPF self service application
  
  As a onboarding self-service application user, I need the ability to see the Corporate
  MPIN name and associated TIN that I have access to within every page withing the
  self-service application, so that the information displayed to me is associated
  to the organization that I am provisioned to.

  @US1525461 @regression
  Scenario: Implement Ribbon - Default Group Value
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can see the list of groups names with default value as "Select Group"
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

  @US1525461 @regression
  Scenario Outline: Implement Ribbon -  Access to Multiple Groups & Single TIN , SSN TIN
    Given I have logged into Optum ID portal with given user name and password
      | OptumIDoremailaddress | EXTERNAL |
      | Password              | EXTERNAL |
    When I navigate to Onboarding self service page with given title "Provider Onboarding"
    Then user can select the below Group and TIN
      | Group | <Group> |
      | TIN   | <TIN>   |
    Then User should be able to logout from application and redirect to "Sign In With Your Optum ID - Optum ID" page.

    Examples: 
      | Group                        | TIN       |
      | VIRGINIA MASON MEDICAL CENTER| 910565539 |
      | ARIZONA COMMUNITY PHYSICIANS | 860767800 |
