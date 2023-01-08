Feature: BuySellAndRead application search feature

  @MB-6
  Scenario: Validating BuySellAndRead search functionality
    Given user navigates to "BuySellAndRead" application
    When user searches for " java data structure " with space in the beginning and at the end
    Then user validates search message "Search results for java data structure."