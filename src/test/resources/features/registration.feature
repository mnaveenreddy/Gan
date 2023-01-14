Feature: Validate the Mandatory fields error message

  Background:
    Given a web browser is at the money gaming home page

  @smoke
  Scenario: Validate the date of birth field error message
    Given the user navigates to the registration page
    When the user enters title, username and password
      | Title | UserName  | PassWord  |
      | Mr    | NewPlayer | Password2 |
    And the user accepts the terms and conditions
    And the user clicks the join now button
    Then the error message is displayed
