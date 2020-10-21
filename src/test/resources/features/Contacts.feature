Feature: Contacts page

  @wip
  Scenario: Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Activities" "Calendar Events"
    Then default page number should be 1

    #homework
  Scenario: login as a driver
    Given the user logged in as "usertype"
    Then the user should be able to login
    And the title contains "Dashboard"
    #driver,storemanager,salesmanager
   #you will have one step definition and it will handle different usertypes