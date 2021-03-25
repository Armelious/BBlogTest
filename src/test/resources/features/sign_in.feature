Feature: Sign In to BBlog

  Scenario: BBLOG-6 Sign in to BBlog with Email
    Given I navigate to HOME"/login"
    When I enter my Email
    And I enter my Password
    And I click Sign in
    Then I expect to be navigated to the Home Page

  Scenario: BBLOG-13 Sign in to BBlog with Username
    Given I navigate to HOME"/login"
    When I enter my Username
    And I enter my Password
    And I click Sign in
    Then I expect to be navigated to the Home Page
