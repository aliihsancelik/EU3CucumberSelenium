
  Feature: Vehicles information

   @wip  @database
    Scenario: Verify Vehicles info with database testing
      When the user logged in as "sales manager"
      And the user navigates to "Fleet" "Vehicle Contracts"
      Then the user clicks the vehicle contract has "Marc" responsible name
      And the information for the vehicle contract has "Marc" responsible name is same with the database

