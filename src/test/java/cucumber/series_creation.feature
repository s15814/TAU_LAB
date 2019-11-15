Feature: Is the TvSeries created?
  The developer wants to know if the TvSeries creation works properly

  Scenario Outline: TvSeries is created
    Given tvSeries number <id> and title <title>
    And with set number of seasons <numberOfSeasons>
    And with a director <directorsName>
    And aired on a platform <platform>
    When the tvShow is added
    Then it will exist with a given id <id> in the database

    Examples:
    | id | title               | numberOfSeasons | directorsName    | platform  |
    | 1  | 'Lost'              | 2               | 'Director'       | 'TV'      |
    | 2  | 'Game of Thrones'   | 6               | 'OtherDirector'  | 'HBO'     |
    | 3  | 'The Walking Dead'  | 3               | 'SomeDirector'   | 'TV'      |
    | 4  | 'The Witcher'       | 1               | 'aDirector'      | 'Netflix' |
    | 5  | 'The Boys'          | 1               | 'AnotherDirector'| 'Prime'   |

  Scenario Outline: Someone got curious how many titles contain the word "the"
    Given series from the first example are in the database
    When i want to find how many titles start with the word <regex>
    Then i found out that <number> shows have that word in their title
    Examples:
    | number | regex  |
    | 3      | 'The.*'|
