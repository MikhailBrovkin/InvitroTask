Feature: Compare prices

  Scenario: I want to compare saved price and price in cart
    Given I'm in main page
    When I search "1515" product
    And I will keep his price
    And I add it to cart
    And I go to cart
    Then I compare their prices
