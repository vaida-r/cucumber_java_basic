Feature: It is Task1 solution
  As a test engineer
  I want to be able to write and execute a scenario for Task1

  Background:
    Given I am on Enter number page


  Scenario Outline: scenario for errors
    When I enter "<number>"
    Then I submit number
    And I see error "<message>"
  @for_errors
    Examples:
    | number | message |
    | 40     | Number is too small|
    | 120    | Number is too big  |
    | abc    |Please enter a number |
    |'50'    |Please enter a number |

  @why_not
    Examples:
    |"70"    |Please enter a number |


  @for_correct
  Scenario: scenario for correct number
    When I enter "<number>"
    Then I submit number
    And I see calculated square root of the number