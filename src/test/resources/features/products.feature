@regression
Feature: Checkout process

  Background: user is login to the site
    Given Login page is opened
    And input information with specify username "standard_user" and password "secret_sauce"

  @222
  Scenario: Verify user is able to see the checkout process is completed
    And add the first two items to the cart
    And navigate to Your Cart page
    When navigate to the Checkout page
    And input your information on the Checkout page
    And click on Finish button on the Checkout page
    Then verify user is able to see the checkout process is completed

  @221
  Scenario: Verify user is able to add content to cart (2 item)
    When add items to the cart
      | Name                  | Index | Price |
      | Sauce Labs Backpack   | 1     | 29.99 |
      | Sauce Labs Bike Light | 2     | 9.99  |
    And navigate to Your Cart page
    Then verify user is able to see items on Your Cart page