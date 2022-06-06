Feature: Check analyzes results

  Scenario: I want to check analyzes results page
    Given I go to analyzes results page
    Then I click on find results
    Then I check red fields
    And I check warning text
