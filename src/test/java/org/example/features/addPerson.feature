Feature: add user

  Scenario: add new user
    When add new person with params "Ira", "+78908908989", "Nothing to tell"
    Then result 200
