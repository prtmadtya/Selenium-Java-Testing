@All
Feature: Login

  @Test1 @Positive @Login
  Scenario: Login valid credential
    Given User is on login page
    When User fill username and password
    And User Click login button
    Then User verify login result

  @Test2 @Negative @Login
  Scenario: login with invalid credential
    Given User is on login page
    When User fill invalid username and password
    And User Click login button
    Then User get error message