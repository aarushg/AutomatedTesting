

Feature: SearchForAward
  This feature deals with the search functionality of the application

  Scenario: go to award page
    Given I go to award page
    And I enter search Award text
    And I click on that award number
    Then I should see that award


  Scenario: Go to through the whole award
    Given Click on edit award
    And Click Continue
    And Click Continue
    And Click Continue
    And Click Continue
    And Click Continue
    And Click Finish
    Then I should see the award number