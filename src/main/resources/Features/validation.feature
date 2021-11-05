Feature: Validation
  As a user
  I want to test validation for sign-in and sign-up
  So that I can be sure that system informs the user by displaying an error.

  Scenario Outline: Check sign-in page for displaying 'Required field' error
    Given User opens '<homePage>' page
    And User clicks Sign in button
    When User clicks Continue button
    Then User checks that 'Enter your email or mobile phone number' error visible
    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check sign-in page for displaying invalid data error
    Given User opens '<homePage>' page
    And User clicks Sign in button
    When User enters '<username>' in the input field
    And User clicks Continue button
    Then User checks that '<errorMessage>' text corresponds to the documentation
    Examples:
      | homePage                | username      | errorMessage                                      |
      | https://www.amazon.com/ | +123456789   | We cannot find an account with that mobile number |
      | https://www.amazon.com/ | invalid@mail | We cannot find an account with that email address |

  Scenario Outline: Check registration page for displaying 'Required field' error
    Given User opens '<homePage>' page
    And User clicks Sign in button
    And User clicks Create your Amazon account button
    And User enters '<email>' to Email field
    And User enters '<password>' to Password field
    And User enters '<confirmPassword>' to Re-enter Password field
    When User clicks Create your Amazon account button without filling in all the fields
    Then User checks that 'Enter your name' error message visible
    Examples:
      | homePage                | email                     | password                  | confirmPassword |
      | https://www.amazon.com/ | vwsmrfpzuale@uniromax.com | test$pass1                | test$pass1      |

  Scenario Outline: Check registration page for displaying 'Required field' error
    Given User opens '<homePage>' page
    And User clicks Sign in button
    And User clicks Create your Amazon account button
    And User enters '<username>' to Your name field
    And User enters '<password>' to Password field
    And User enters '<confirmPassword>' to Re-enter Password field
    When User clicks Create your Amazon account button without filling in all the fields
    Then User checks that 'Enter your email' error message visible
    Examples:
      | homePage                | username                  | password                  | confirmPassword |
      | https://www.amazon.com/ | RegularTester             | test$pass1                | test$pass1      |

  Scenario Outline: Check registration page for displaying 'Required field' error
    Given User opens '<homePage>' page
    And User clicks Sign in button
    And User clicks Create your Amazon account button
    And User enters '<username>' to Your name field
    And User enters '<email>' to Email field
    And User enters '<confirmPassword>' to Re-enter Password field
    When User clicks Create your Amazon account button without filling in all the fields
    Then User checks that 'Enter your password' error message visible
    Examples:
      | homePage                | username                  | email                     | confirmPassword |
      | https://www.amazon.com/ | RegularTester             | vwsmrfpzuale@uniromax.com | test$pass1      |

  Scenario Outline: Check registration page for displaying 'Required field' error
    Given User opens '<homePage>' page
    And User clicks Sign in button
    And User clicks Create your Amazon account button
    And User enters '<username>' to Your name field
    And User enters '<email>' to Email field
    And User enters '<password>' to Password field
    When User clicks Create your Amazon account button without filling in all the fields
    Then User checks that 'Type your password again' error message visible
    Examples:
      | homePage                | username                  | email                     | password       |
      | https://www.amazon.com/ | RegularTester             | vwsmrfpzuale@uniromax.com | test$pass1     |

