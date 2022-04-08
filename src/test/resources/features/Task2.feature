Feature: It is Task2 solution
  As a test engineer
  I want to be able to write and execute a scenario for Task2

  Background:
    Given people with jobs page
    Given I see whole list


  Scenario Outline: add new person
    When I press the Add person button
    And I enter person data
      |name | <name> |
      |job  | <job>|
    And I click the Add button
    Then I see person with "<name>" and "<job>"
    And I see whole list
    Examples:
      |name  | job   |
      |Jonas | player|


  Scenario: add
    When I press the Add person button
    And I enter new person data with name:
      |Kestutis|
    And I click the Add button
    And I press the Add person button
    And I enter new person data with name:
      |Petras|
    And I click the Add button
    And I see person with name "Kestutis"
    And I see person with name "Petras"
    And I see whole list


  Scenario Outline: edit a person and then click Edit
    When I click the Edit for person with "<name>"
    And I enter person data
      |name | <newname> |
      |job  | <newjob> |
    And I click Edit button
    Then I do not see person with "<name>"
    And I see person with "<newname>" and "<newjob>"
    And I see whole list
    Examples:
     |name  | newname | newjob |
     |Jill | Vytis    | brolis |


  Scenario Outline: edit a person and then click cancel
    When I click the Edit for person with "<name>"
    And I enter person data
      |name | <newname> |
      |job  | <newjob> |
    And I click Cancel button
    Then I do not see person with "<newname>"
    And I see person with "<name>" and "<job>"
    And I see person with name "<name>"
    And I see whole list
    Examples:
      |name  | newname | newjob | job |
      |Jill | Vytis    | brolis |     |


  Scenario Outline: remove a person
    When I click Remove for person with "<name>"
    Then I do not see person with "<name>"
    And I see whole list
    Examples:
      |name|
      |Mike|



  Scenario: add new person, after that reset list
    When I press the Add person button
    And I enter new person data:
      |name | Petras |
      |job  | speaker|
    And I click the Add button
    Then I see person with "Petras" and "speaker"
    And I see whole list
    Then I click Reset list button
    And I do not see person with "Petras"
    And I see whole list


  Scenario Outline: remove a person, after that reset list
    When I click Remove for person with "<name>"
    Then I do not see person with "<name>"
    And I see whole list
    Then I click Reset list button
    And I see person with name "<name>"
    And I see whole list
    Examples:
      |name|
      |Mike|












