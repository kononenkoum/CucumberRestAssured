# language: en

Feature: check person feature request

  Scenario: check person list data
    When ask person list
    Then get person list
    And all person info contains "Some info about"