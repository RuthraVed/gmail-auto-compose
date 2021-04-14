Feature: Compose an email using Gmail
  Scenario: Verify that an email is composed on Gmail and send
    Given user is already logged-in and on Gmail homepage
    When user clicks on the compose button
    And user gives the recipients email address
    And user gives the subject of email
    And user writes in the body of email
    Then user clicks the send button