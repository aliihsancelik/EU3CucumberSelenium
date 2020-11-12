Feature: Contacts page

  @paralel
  Scenario: Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Activities" "Calendar Events"
    Then default page number should be 1


  Scenario: Menu Options
    Given the user is on the login page
    And the user logged in as "driver"
    Then the user should see following options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |


  Scenario: login as a given user
    Given the user is on the login page
    When the user logs in using following credentials
      | username  | user10      |
      | password  | UserUser123 |
      | firstname | Brenden     |
      | lastname  | Schneider   |
    Then the user should be able to login


   #this is data driven testing in this file not the all pipes included scenarios and this is the different way, actual way is in AccountTypes.feature
  Scenario Outline: login as a given user <user>
    Given the user is on the login page
    When the user logs in using following credentials
      | username  | <user>      |
      | password  | UserUser123 |
      | firstname | <firstName> |
      | lastname  | <lastName>  |
    Then the user should be able to login

    Examples:
      | user           | firstName | lastName  |
      | user10         | Brenden   | Schneider |
      | storemanager85 | Stephan   | Haley     |


  @wip @database
  Scenario: Contacts test with email
    When the user logged in as "sales manager"
    And the user navigates to "Customers" "Contacts"
    When the user clicks the "mbrackstone9@example.com" from contacts
    Then the information for "mbrackstone9@example.com" should be same with database


  Scenario Outline: Contacts test with email (same steps with previous but in DDT format)
    When the user logged in as "sales manager"
    And the user navigates to "Customers" "Contacts"
    When the user clicks the "<email>" from contacts
    Then the information for "<email>" should be same with database
    Examples:
      | email                    |
      | mbrackstone9@example.com |
      | mike.jordan@hotmail.com  |


