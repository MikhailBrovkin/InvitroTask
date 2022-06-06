Feature: Change city

  Scenario: I want to change city
    Given I go to main page
    When I click to choose another city
    And I write in search "Омск"
    And I check that the search is correct and contains "Омск"
    And I choose city
    Then I see "Омск" city on the main page