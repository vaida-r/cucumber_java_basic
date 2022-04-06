Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

  Background:
    Given I am on age page

  Scenario: a new scenario 1 with regex
    When I enter name: "Ann"
    And I enter age: 5
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  Scenario: a new scenario 2 with regex
    When I enter name: "Bob"
    And I enter age: 61
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"


  @mano @tavo
  Scenario: a new scenario error
    When I enter name: "John"
    And I click submit age
    Then I see error: "You haven't entered anything in age field"
    And I am not navigated to age message page
