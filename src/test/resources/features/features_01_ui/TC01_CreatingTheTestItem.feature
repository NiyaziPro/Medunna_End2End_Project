@medunna_end2end
Feature: TC01 Creating a Test Item on Medunna

  Scenario Outline: TC01 Positive scenario
    Given the user navigates to the "baseUrl" website
    When the user clicks on the user icon
    And clicks on the sign in option
    And enters the username in the username field
    And enters the password in the password field
    And clicks on the sign in button
    And clicks on the Items and Titles option
    And clicks on the Test Item option
    And clicks on the Create a new Test Item button
    And enters a name in the Name field
    And enters a "<description>" in the Description field
    And enters a "<price>" in the Price field
    And enters a "<Min. Value>" in the Default Min. Value field
    And enters a "<Max. Value>" in the Default Max. Value field
    And clicks on the save button
    Then verify A new Test Item is created succesfully
    And closes the application
    Examples:
      | description                   | price  | Min. Value | Max. Value |
      | This is created for a UI test | 150.00 | 10 mg/dL   | 20 mg/dL   |

