Feature: Sign In to BBlog

  Scenario: BBLOG-10 Verify I am able to Navigate to Sign Up
    Given I navigated to "https://qa-task.backbasecloud.com/#/"
    When I look at the title
    Then I can see "it-agile" in the title

