Feature: Smoke
  As a user
  I want to check the basic functionality of the site accessible without authorization
  So that I can go to more detailed tests.

  Scenario Outline: Check basic functionality of the site
    Given User opens '<homePage>' page
    And User checks logo visibility
    And User checks Sign-in button visibility
    And User checks main menu visibility
    And User checks search field visibility
    And User checks carousel visibility
    And User checks card layout visibility
    And User checks Conditions of use visibility
    When User enters '<keyword>' into the search field
    And User clicks search submit button
    And User clicks Sort dropdown menu
    And User selects Sort Price: Low to High
    And User clicks on first result on page
    And User adds product to cart
    And User clicks Card button
    And User returns to home page
    Then User checks that '<productAmount>' product has been added to the cart

    Examples:
      |homePage               |keyword         |productAmount|
      |https://www.amazon.com/|Lenovo Legion 17|1            |
