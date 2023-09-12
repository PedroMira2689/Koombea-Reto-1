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


#
#    @testCharacter404StatusCode
#  Scenario: Get a fake character
#    When the user submits a request to fetch a fake character
#    Then the api response shows us the 404 status code
#
#  @testLocation200StatusCode
#  Scenario Outline: Get a real location
#    When the user submits a request to fetch a real location with id
#      | idValue   |
#      | <idValue> |
#    Then the api response shows us the 200 status code
#    And the locations api response includes a field named id with the value of
#      | idValue   |
#      | <idValue> |
#    And the api response includes a header named X-Nf-Request-Id with the value of 01H
#    Examples:
#      | idValue |
#      | 2       |
#      | 20      |
#
#  @testLocation404StatusCode
#  Scenario: Get a fake location
#    When the user submits a request to fetch a fake location
#    Then the api response shows us the 404 status code
#
#  @testEpisode200StatusCode
#  Scenario Outline: Get a real episode
#    When the user submits a request to fetch a real episode with id
#      | idValue   |
#      | <idValue> |
#    Then the api response shows us the 200 status code
#    And the episodes api response includes a field named id with the value of
#      | idValue   |
#      | <idValue> |
#    And The api response includes a header named X-Nf-Request-Id with the value of 01H
#    Examples:
#      | idValue |
#      | 5       |
#      | 4       |
#
#  @testEpisode404StatusCode
#  Scenario: Get a fake episode
#    When the user submits a request to fetch a fake episode
#    Then the api response shows us the 404 status code