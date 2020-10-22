
   @smoke
   Feature: Users should be able to login

     #Background helps us to use common steps for all scenarios in this file-
     #it can not jump and go back again this is only for common BACKgrounds
     Background:
       Given the user is on the login page

   @driver  @login  #//@smoke
   Scenario: Login as a driver
    #Given the user is on the login page
    When the user enters the driver information
    Then the user should be able to login

    @sales_manager  @login  #//@smoke
   Scenario: Login as a sales manager
    #Given the user is on the login page
    When the user enters the sales manager information
    Then the user should be able to login

     @store_manager  @login  #//@smoke
     Scenario: Login as a store manager
      #Given the user is on the login page
      When the user enters the store manager information
      Then the user should be able to login

      #homework
     Scenario: login as a user
       #Given the user is on the login page
       When the user logged in as "store manager"
       Then the title contains "Dashboard"
    #driver,storemanager,salesmanager
   #you will have one step definition and it will handle different usertypes
