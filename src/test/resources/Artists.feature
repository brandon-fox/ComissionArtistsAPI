Feature: Storing information about artists details
  As a user
  I want to interact with details about Vindicta's comission artists
  So that I can learn more about their unique traits

  Scenario: Get a list of all artists
    When I request a list of all the artists
    Then I get back a list of artists

  Scenario: Get a particular artist details
    Given an artist ID 1 exists
    When I request an artist using their ID 1
    Then I get back that artists details

  Scenario: An artist should have a list of skills
    Given an artist ID 1 exists
    When I request an artist using their ID 1
    Then I get back that artists details
    And that artists details contains a list of skills

  Scenario: Add an artist to the collection
    When I submit a new artist "Joe Clark"
    Then the response code is 200
    When  I request a list of all the artists
    Then the new artist "Joe Clark" is listed
