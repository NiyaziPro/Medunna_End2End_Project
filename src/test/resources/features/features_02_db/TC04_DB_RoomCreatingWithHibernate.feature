@hb
Feature: DataBase Testing
  Scenario: Room creating with Hibernate
    Given user create room in database with hibernate
    And user connects with the database
    And send query for creating a room
    Then verify A new Room is created
    And closes the connection