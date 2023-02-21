Feature: User should be able to login using correct credential


  Scenario: Positive login scenario
    Given user is on login page of web table app
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks to login button
    Then user should see url contains orders
  @wip
  Scenario: Positive login scenario
    Given user is on login page of web table app
    When user enters username "Test" password "Tester" and logins
    Then user should see url contains orders
    #1- implement this new step
    #2- create login method in WebTableLoginTable
    # this login method should have multiple different overloaded version
