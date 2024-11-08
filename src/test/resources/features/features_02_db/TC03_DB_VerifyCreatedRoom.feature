@room
  Feature: TC02 DataBase Room Validation
    Scenario: Testing the room via DB
      Given user connects with the database
      When send query for created room
      Then validates created room from resultset





