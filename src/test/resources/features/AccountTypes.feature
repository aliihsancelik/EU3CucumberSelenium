Feature: Account Types
  @wip
  Scenario: Driver user
    Given the user logged in as "driver"
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendar Events - Activities"

  @wip
  Scenario: Sales manager user
    Given the user logged in as "sales manager"
    Then the user navigates to "Customers" "Accounts"
    Then the title contains "Accounts - Customers"
  @wip
  Scenario: Store manager user
    Given the user logged in as "store manager"
    When the user navigates to "Customers" "Contacts"
    Then the title contains "Contacts - Customers"


    #Data Driven Testing way of the previous 3 Scenarios like Data Provider in testNG :
  Scenario Outline: Different user types login,navigates and verify title
    Given the user is on the login page
    When the user logged in as "<userType>"
    Then the user navigates to "<tab>" "<module>"
    And the title contains "<title>"
    Examples:
      | userType      | tab        | module          | title                        |
      | driver        | Activities | Calendar Events | Calendar Events - Activities |
      | sales manager | Customers  | Accounts        | Accounts - Customers         |
      | store manager | Customers  | Contacts        | Contacts - Customers         |
    #command+alt+L is fitting the pipes
  #We don't use apache poi for the excel docs with cucumber like testNG we get the columns and rows from excel then write in pipes.

