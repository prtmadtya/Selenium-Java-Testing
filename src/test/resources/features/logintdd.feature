Feature: Login with TDD

  @TDD
  Scenario Outline: Login with TDD
    Given User is on login page
    When User input <username> and <password>
    And User Click login button
    Then User get verify login result

    Examples:
      | username      | password     | result |
      | standard_user | secret_sauce | passed |
      | 123           | secret_sauce | failed |
      | standard_user | 123          | failed |