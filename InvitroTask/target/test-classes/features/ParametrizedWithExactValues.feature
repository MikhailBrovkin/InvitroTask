Feature: Create parametrized step with exact values

  Scenario Outline: I create parametrized step with exact values
    Given Main page
    And My city is "Москва"
    Then I click on <chapter>
    Examples:
      |      chapter     |
      | "Запись к врачу" |
      |     "Анализы"    |
      |      "Акции"     |
      |     "Адреса"     |

