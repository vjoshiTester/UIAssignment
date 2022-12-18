@CD02 @Regression
Feature: CD02_SendCustomerMessage
  Description: Customer Message

  Scenario Outline: Send Customer Message
    Given I launch browser "chrome" in "GUI" and open "<URL>"
    When I login the Application as User "automation" and password "dealerfxqa"
    And I click "Communication Dashboard" on the 'Home' page
    And I click "Customer" on 'Communication Dashboard' window
    And I click "Edit" on 'Communication Dashboard' window
    And I click "Message Customer" on 'Communication Dashboard' window
    And I enter "<SEARCHPARAMETER>" of the customer on 'Communication Dashboard' window
    And I send and validate "<COUNT>" customer messages on 'Communication Dashboard' window
    And I click "Close" on 'Communication Dashboard' window

    Examples: below data set for data driven
      | URL      | COUNT | SEARCHPARAMETER | Field4 |
      | TEST2DFX |     1 |      6477120113 | Value4 |
