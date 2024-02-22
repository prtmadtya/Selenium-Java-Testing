Feature: Parabank Registration

  @positive @register
  Scenario: Success Register
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    When user input name
    And user input address detail
    And user fll valid username and password
    And user input password confirmation
    When user click register button
    Then user regist successfully

  @negative @register
  Scenario: failed register - missmatch password
    Given user is on parabank homepage
    When user click register link button
    Then user is in register page
    When user input name
    And user input address detail
    And user fll valid username and password
    And user input invalid password confirmation
    When user click register button
    Then user get error password did not match