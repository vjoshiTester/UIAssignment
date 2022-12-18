Feature: Google Search
  Description : Google search a criteria, move to amazon and purchase

  @GoogleSearch
  Scenario Outline: Amazon search and buy
    Given I launch browser "chrome" in "GUI" and open "<URL>"
    And I search the  "<Criteria>" on the 'Search' page
    And I note down the search results
    And I click on Amazon link
    And I click on All button on search and select "<Category>" as category
    And I search Product "<ProductSearch>" from the search bar
    And I apply "<LowRange>" to "<HighRange>" as filter range
    And Validate the products displayed on the screen are within "<LowRange>" to "<HighRange>" range

    Examples: below data set for data driven
      | URL    | LowRange | HighRange | ProductSearch  | Category    | Criteria |
      | GOOGLE |    30000 |     50000 | Dell Computers | Electronics | Amazon   |
