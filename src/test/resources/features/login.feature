
   @smoke
   Feature: Users should be able to login

   @driver  @login  #//@smoke
   Scenario: Login as a driver
    Given the user is on the login page
    When the user enters the driver information
    Then the user should be able to login

    @sales_manager  @login  #//@smoke
   Scenario: Login as a sales manager
    Given the user is on the login page
    When the user enters the sales manager information
    Then the user should be able to login

     @store_manager  @login  #//@smoke
     Scenario: Login as a store manager
      Given the user is on the login page
      When the user enters the store manager information
      Then the user should be able to login

     @wip #homework
     Scenario: login as a driver
       Given the user is on the login page
       When the user logged in as "store manager"
       Then the user should be able to login
       And the title contains "Dashboard"
    #driver,storemanager,salesmanager
   #you will have one step definition and it will handle different usertypes
