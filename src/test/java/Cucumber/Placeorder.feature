
@tag
Feature: Purchasing the order from Ecommerce website
  I want to use this template for my feature file

Background: 
Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test for place an order
    Given Logged in with valid username <username> & valid password <password>
    When I add product <productName> to the cart
    And  Check out productName <productName> in cart & place the order
    Then I verify the confirmation message "Thankyou for the order."

    Examples: 
      | nusername  				| password   | productName    |
      | Tfq@gmail.com     | Abc@#123   | IPHONE 13 PRO  |
     
