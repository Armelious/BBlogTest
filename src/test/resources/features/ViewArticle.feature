Feature: View an articles details

  Background: @BBLOG-6 Sign in to BBlog with Email
    Given I navigate to HOME"/login"
    When I enter my Email
    When I enter my Password
    When I click Sign in

  Scenario: @BBLOG-5 View an Article from Global Feed
    When I click "Global Feed"
    When I click the header of the 1st Article
    Then I verify I can view the articles content

  Scenario: @BBLOG-17 View my Articles content
    When I click my Username
    When I click the header of the 1st Article
    Then I verify I can view the articles content

  Scenario Outline: @BBLOG-18 Add a comment to my Article
    When I click my Username
    When I click the header of the 1st Article
    When I enter the comment "<comment>"
    When I click Post Comment Button
    Then I verify my comment "<comment>" was added

    Examples:
    | comment |
    | Hey Great article on Testing! |
