@AM_Regression-debug
Feature: This Test suite is Appointment Management Regression suite
  Description : to verify Appointment Management function work properly

  @AM_Regression13_RecallVehicleService-TEST2
  Scenario Outline: AM_Regression13 ,Verify the Appointment Management Recall function on Vehicle page and Service page
    Given I launch browser "chrome" in "GUI" and open "<URL>"
    And I set "<DMS>" to the 'DMS'
    When I login the Application as User "automation" and password "dealerfxqa"
    And I select the Dealer with "<DealerName>" or "<DealerCode>" in Dealer Page
    Then I verify Page Info "ng-scope" and Browser log on 'DASHBOARD' page
    And I verify 'UserName' is "Automation User" on 'DASHBOARD' page
    When I click "Next week" button on 'DASHBOARD' page
    And I select "1th" available weekday on 'DASHBOARD' page
    And I click "CREATE" button on 'DASHBOARD' page
    And I search "VIN" with "<VIN>" on 'CUSTOMER SEARCH' page
    And I click "+" button 'under vehicle' on 'CUSTOMER SEARCH' page
    Then I verify the 'Recall count' and 'Recall list' on 'CLIENT & VEHICLE' page
    When I set customer data on 'CLIENT & VEHICLE' page
      | FieldName            | Value                  |
      | Customer E-mail      | testdealerfx@gmail.com |
    And I enter "<Odometer>" on 'CLIENT & VEHICLE' page
    And I click "NEXT" button on 'CLIENT & VEHICLE' page
    And I click "NEXT" button if on 'HISTORY' page in AM
     ## Verify in Service Page
    And I goto "RECALLS" tab on 'SERVICES' page in AM
    Then I verify the 'Recall count' and 'Recall list' on 'SERVICES' page in AM
    And I verify the 'Recall count' status "<Recall>" on 'SERVICES' page in AM
    And I signout from AM

    Examples: below data set for data driven
      |URL         |DMS   |DealerName            |DealerCode   |VIN               |Recall  | Odometer   |
#      |TEST2AL     |Dummy |John Hine Mazda       |             |JM3KE4DE2D0162071 |yes     |52000       |
#      |TEST2AL     |Dummy |Volkswagen of Naples  |             |3VWSW31C37M506413 |yes     |52000       |
#      |TEST2AL     |Dummy |Audi Oakville         |7920         |WAUDF68E85A454160 |no      |53000       |
#      |TEST2AL     |Dummy |Mossy Nissan          |3090         |1N6AA07C68N321957 |no      |56000       |
#   #### STAGE 2
#      |STAGE2AL     |Dummy |John Hine Mazda       |             |JM3KE4DE2D0162071 |yes     |52000       |
      |STAGE2AL     |Dummy |Volkswagen of Naples  |             |3VWSW31C37M506413 |yes     |52000       |
#      |STAGE2AL     |Dummy |Audi Oakville         |7920         |WAUDF68E85A454160 |no      |53000       |
#      |STAGE2AL     |Dummy |Mossy Nissan          |3090         |1N6AA07C68N321957 |yes      |56000       |
# #### PROD 2
#      |PROD2AL     |Dummy |John Hine Mazda       |             |JM3KE4DE2D0162071 |yes     |52000       |
#      |PROD2AL     |Dummy |Volkswagen of Naples  |             |3VWSW31C37M506413 |yes     |52000       |
#      |PROD2AL     |Dummy |Audi Oakville         |7920         |WAUDF68E85A454160 |no      |53000       |
#      |PROD2AL     |Dummy |Mossy Nissan          |3090         |1N6AA07C68N321957 |yes      |56000       |