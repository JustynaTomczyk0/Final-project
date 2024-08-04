Feature: purchase

  @done
  Scenario: Purchase of the product
    Given a registered user is on the home page
    And the user clicks on Sign in
    And the user fills Log in form
    And the user clicks Sign in button
    And the user click on My store logo
    And the user searches Hummingbird Printed Sweater on the home page
    And the user clicks on the name of product
    And the user chooses size M
    And the user chooses 5 pieces of the product
    And the user adds products to cart
    When the user clicks Proceed to checkout
    And the user clicks Proceed to checkout in the Shopping Cart
    And the user confirms address and clicks Continue
    And the user confirms Self pick up as a shipping method
    And the user chooses Pay by check as a payment method
    And the user agrees to the terms of service
    And the user clicks Place order button
    Then the user takes a screenshot with the order confirmation and the amount

