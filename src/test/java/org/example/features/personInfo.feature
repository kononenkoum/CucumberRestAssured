# language: en

Feature: Check personInfo request

  Scenario Template: check different names
    When send <name>
    Then result <status>
    And body.phone is <phone>
    Examples:
    |name|status|phone|
    |"Ivan"|200 |"+79863456545"|
    |"Oleg" |200 |          |
    |       |400 |          |
