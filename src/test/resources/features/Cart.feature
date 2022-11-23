@Debug
Feature: Cart tests
  Scenario: Add product to cart
    Given the customer navigates to the Website
    When the customer adds a product to the cart
    Then a message about the added element is displayed
    And the product can be seen in the cart popup