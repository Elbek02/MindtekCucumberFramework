@regression @ui
Feature: Validating Etsy application search filter functionality

  #Before
  Background: Repeated first steps in each scenario
    Given user navigates to "Etsy" application

  @RTB-1
  Scenario:Validating search result
    When user searches for "sofa"
    Then user validates search result items name contains keyword "sofa"
  #After

  @RTB-2
  Scenario Outline: Validating price range filter functionality for searched item
    When user searches for "<item>"
    And user applies price filter "<price>" dollars
    Then user validates that item prices are over "<price>" dollars
    And user validates search result items name contains keyword "sofa"

    Examples:
      | item   | price       |
      | sofa   | over 1500   |
      | chair  | under 250   |
      | carpet | 250 to 750  |
      | table  | 750 to 1500 |