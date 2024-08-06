Feature: add new address

  @done
  Scenario Outline: Add a new user address
    Given a registered user is on the home page
    And the user clicks on Sign in
    And the user fills Log in form
    And the user clicks Sign in button
    And the user clicks Addresses on Your account page
    When the user clicks Create new address button
    And the user fills the address form with "<address>", "<city>", "<postCode>", "<phone>"
    And the user clicks Save button
    Then Your addresses page should include the new address
    Examples:
      |address  | city | postCode | phone    |
      |def      | Lodz | 93-444   | 487926641|
