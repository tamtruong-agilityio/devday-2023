@regression
Feature: Login

  @111
  Scenario: Verify user is able to login to the site
    Given Login page is opened
    When input information with specify username "standard_user" and password "secret_sauce"
    Then verify user is able to login to the site