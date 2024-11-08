@dbt
  Feature: DataBase Test with Hibernate
    Scenario: TC01
      Given user connects with the database
      And send query for test item
      Then verifies that the Test Item is created
      And closes the connection