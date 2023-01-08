@regression @ui
Feature:Validating HRMApp Admin/Edit existing user

  @MB6-223
  Scenario: Validating Edit existing user
    Given user navigates to "HRMApp" application
    When user enters username "Admin" and password "admin123" and clicks login button
    And user clicks on "PIM" section and user selects random employee
    And user clicks on edit button to edit existing employee info
    And user clicks on save button
    Then user validates success message displayed
