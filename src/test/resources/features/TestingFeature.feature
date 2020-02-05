Feature: Employees info

  @regression @api
  Scenario Outline: Get employees by specific id
    When User request user by id "<id>"
    Then It should be equal to "<name>" and "<last_name>"
  Examples:
  | id | name     | last_name   |
  | 5 | Charles   | Morris      |
  | 2 | Janet     | Weaver      |

  @regression @ui
    Scenario: Find Frameworkium page in google
      When User Is on google search page
      And Try to search Frameworkium and click on it
      Then Results should show framework documentation

