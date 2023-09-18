Feature: As a QA Engineer
  I want to validate the Jokes Parade API
  Background:
    Given that the user knows the jokes parade api

  @testJokes200StatusCode
  Scenario: Get a random existing programming jokes
    When the user submits a request to look for a random programming jokes
    Then the api response with 200 status code
    And the api response with an existing id
    And the api response includes a header named Alt-Svc with the value of h3=":443"; ma=2592000,h3-29=":443"; ma=2592000

  @testJokes404StatusCode
  Scenario: Get a random existing programming jokes
    When the user submits an invalid request to look for a random programming jokes
    Then the api response with 404 status code

  @testRandomJokeStatus200
  Scenario: Get a random joke
    When the user submits a request to look for a random joke
    Then the api response with 200 status code
    And the api response with an existing type for a random joke
   And the api response includes a header named Alt-Svc with the value of h3=":443"; ma=2592000,h3-29=":443"; ma=2592000

