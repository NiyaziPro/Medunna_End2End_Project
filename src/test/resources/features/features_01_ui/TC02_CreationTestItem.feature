@ui1
Feature: Creating a Test Item on Medunna

  Scenario: TC01 - Positive scenario
    Given the user logs into the "https://medunna.com" page as admin
    And Goes to the Test Item page from Items&Titles and clicks Create new Test Item
    And enters valid data into fields and clicks on the Save button
    Then Verifies that the Test Item has been created and displays the message "A new Test Item is created"
    And closes the application

  @ui2
  Scenario: TC02 - Positive Scenario
    Given the user logs into the "https://medunna.com" page as admin
    And Goes to the Test Item page from Items&Titles and clicks Create new Test Item
    And Test Item is created with the following data: name "Abcda", description "This is created for a E2E Test", price "146.55" , minValue "8 mg/dL", maxValue "14 mg/dL"
    Then Verifies that the Test Item has been created and displays the message "A new Test Item is created"
    And closes the application

  @ui3
  Scenario Outline: TC03 - Negative Scenario
    Given the user logs into the "https://medunna.com" page as admin
    And Goes to the Test Item page from Items&Titles and clicks Create new Test Item
    And enters into fields the following data: name "<name>", description "<description>", price "<price>", minValue "<minValue>", maxValue "<maxValue>"
    Then verifies that the Test Item has not been created
    And closes the application
    Examples:
      | name      | description                  | price  | minValue | maxValue |
      | TestItem1 | This is created for E2E Test |        | 8 mg/dL  | 14 mg/dL |
      |           | This is created for E2E Test | 155.99 | 8 mg/dL  | 14 mg/dL |
      |           | This is created for E2E Test |        | 8 mg/dL  | 14 mg/dL |
