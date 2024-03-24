Feature: API features

  Scenario: 1 Authorization checks
    Given Register new user in the system
    When Login with new User credentials
    Then Logout with logged in user

  Scenario: 2 Get cars brands
    Given Login as Registered User
    Then Get All cars brands

  Scenario: 3 Put car expenses
    Given Login as Registered User
