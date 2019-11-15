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
    | id | title          | numberOfSeasons | directorsName | platform  |
    | 1  | 'Lost'         | 2               | 'Director'    | 'TV' |
    | 2  | 'Game of Thrones'   | 6          | 'OtherDirector'   | 'HBO' |