@medunna_end2end @dbt
  Feature: TC01 DataBase Test Item Validation
    Scenario: Testing the Test Item via DB
      Given Admin connect to the DataBase
      When send query for created test item
      Then validates created test item from resultset