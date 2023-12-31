@Cart @Regression
Feature: Add to Cart
  User want to verify the add to cart functionality

  @Cart
  Scenario: User is on Homepage
    Given Open Chrome and Launch the amazon application
    When User on homepage
    Then check if cart is empty
