@Regression
Feature: Login functionality for different user types

  @login
  Scenario: Login as a host
    Given I am on the fourstay homepage
    When I login as a host
    Then I should be able verify I am logged in

  Scenario: Login as a guest
    Given I am on the fourstay homepage
    When I login as a guest
    Then I should be able verify I am logged in

  Scenario Outline: Login as a guest
    Given I am on the fourstay homepage
    When I login as a <type>
    Then I should be able verify I am logged in

    Examples: 
      | type  |
      | host  |
      | guest |