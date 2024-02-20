@All
Feature: Login

  @Test1
  Scenario: Login
    Given User is on login page
    When User fill username and password
    And User Click login button
    Then User verify login result