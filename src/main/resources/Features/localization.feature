Feature: Localization
  As a user
  I want to test language switching function
  So I can be sure that this resource is ready for work in different locales.

  Scenario Outline:
    When User opens '<homePage>' page
    And User clicks Change language
    When User selects '<language>' language
    And User confirm changes
    Then User checks that interface language was changed by '<All>' button text
    Examples:
      | homePage               | language | All   |
      | https://www.amazon.com/|Deutsch   | Alle  |
      | https://www.amazon.com/|Portugues | Todos |
