@SSA_Regression04-BookApptNewCustomerNotVIN-TEST2
Feature: This Test suite is Schedule Service Appointment Regression suite on Test2
  Description : to verify a set of functions in Schedule Service Appointment system work properly

  @SSA_Regression04_BookApptNewCustomerNotVIN-TEST2
  Scenario Outline: SSARegression04, Verify the function of book a new appointment for a new customer Not by VIN in Test2
    Given I launch browser "chrome" in "GUI" and open "<URL>"
    And I set "<DMS>" to the 'DMS'
    When I click "I am a new customer" button on 'Search' page in SSA
    And I enter vehicle data set on 'Vehicle Info' page in SSA
      | FieldName        |Value                |
      | Make             | AUDI                |
      | Year             | 2016                |
      | Model            | A3 (1.8L)           |
      | Transmission     | Automatic           |
      | Engine Size      | 4CYL                |
      | Drive Train      | quattro             |
    And I input "<Odometer>" to continue on 'Vehicle Info' page in SSA
    And I add "1th" concern with comment "" on 'Customer Concerns' page
    And I click "NEXT" button on 'Customer Concerns' page
    And I click "NEXT" button on 'Service' page in SSA
    And I click week ">" button "1" times on 'Schedule' page
    And I choose "1th" available time on 'Schedule' page
    And I choose "1th" available transportation option on 'Schedule' page
    And I click "NEXT" button on 'Schedule' page
    And I enter customer data set on 'Appointment Summary' page
      | FieldName      |Value                   |
      | First name     | David                  |
      | Last name      | dfxQA                  |
      | Phone number   | 9058761234             |
      | Email address  | testdealerfx@gmail.com |
    And I click "Confirm appointment" button on 'Appointment Summary' page
    Then I see "Thank you" message on 'Confirmation' page
    Examples: below data set for data driven
      |URL            |DMS     |DealerName  |Transportation|Odometer |ServiceAdvisor|
      |TEST2SSAAUDIS |Dummy   |            |Own ride      |37800    |1             |

