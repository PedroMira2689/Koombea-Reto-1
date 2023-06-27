Feature: As a QA Engineer
  I want to validate the Rick And Morty apis

  Background:
    Given that the user knows the rick and morty api

  @testCharacter200StatusCode
  Scenario Outline: Get a real character
    When the user submits a request to fetch a real character with id
      | idValue   |
      | <idValue> |
    Then the api response shows us the 200 status code
    And the api response includes a field named id with the value of
      | idValue   |
      | <idValue> |
    And the api response includes a header named X-Nf-Request-Id with the value of 01H
    Examples:
      | idValue |
      | 71      |
      | 72      |

  @testCharacter404StatusCode
  Scenario: Get a fake character
    When the user submits a request to fetch a fake character
    Then the api response shows us the 404 status code

  @testLocation200StatusCode
  Scenario Outline: Get a real location
    When the user submits a request to fetch a real location with id
      | idValue   |
      | <idValue> |
    Then the api response shows us the 200 status code
    And the locations api response includes a field named id with the value of
      | idValue   |
      | <idValue> |
    And the api response includes a header named X-Nf-Request-Id with the value of 01H
    Examples:
      | idValue |
      | 2       |
      | 20      |

  @testLocation404StatusCode
  Scenario: Get a fake location
    When the user submits a request to fetch a fake location
    Then the api response shows us the 404 status code

  @testEpisode200StatusCode
  Scenario Outline: Get a real episode
    When the user submits a request to fetch a real episode with id
      | idValue   |
      | <idValue> |
    Then the api response shows us the 200 status code
    And the episodes api response includes a field named id with the value of
      | idValue   |
      | <idValue> |
    And The api response includes a header named X-Nf-Request-Id with the value of 01H
    Examples:
      | idValue |
      | 5       |
      | 4       |

  @testEpisode404StatusCode
  Scenario: Get a fake episode
    When the user submits a request to fetch a fake episode
    Then the api response shows us the 404 status code