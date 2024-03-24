Feature: UI features

  Scenario: 1 Verify Home page opens fine
    Given I navigate to the Home page
    Then Check if current URL is HomePage URL


  Scenario: 2 Check if all page elements on Home page are presents
    Given I navigate to the Home page
    Then Check all page element on Home page are present

      #Не работает проверка элементов на странице в headless
  Scenario: 3 Check if login and logout as Guest is possible
    Given I navigate to the Home page
    When Click on Guest Login button
    Then Check if I logged in as Guest
    Then User logout and Home Page Url check


  Scenario: 4 Check if login and logout as Registered User is possible
    Given I navigate to the Home page
    When Click on Sign in button
    And Fill in User login credentials
    Then Submit Sign in form
    And Check if I logged in as User
    Then User logout and Home Page Url check


  Scenario: 5 Check New User registration
    Given I navigate to the Home page
    When Click on SingUp button
    And Fill in New user credentials
    And Click Register button
    Then Check if current URL is UserPage-Garage URL
    And Profile User name is present on Profile page


  Scenario: 6 Garage add car possibility check
    Given I login as registered User
    When Press add car button
    And Fill in car data form
    Then Check car added


  Scenario: 7 Check car data update
    Given I login as registered User
    And Add new car
    Then Update car data
    Then Remove last added car


  Scenario: 8 Check Fuel expenses apply
    Given I login as registered User
    And Add new car to check expenses
    Then Go to Fuel expenses page
    And Add Fuel expenses to car added




