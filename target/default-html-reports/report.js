$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Vehicles.feature");
formatter.feature({
  "name": "Vehicles information",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify Vehicles info with database testing",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    },
    {
      "name": "@database"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user logged in as \"sales manager\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.vytrack.step_definitions.LoginStepDefs.the_user_logged_in_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to \"Fleet\" \"Vehicle Contracts\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.vytrack.step_definitions.NavigationMenuStepDefs.the_user_navigates_to(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks the vehicle contract has \"Marc\" responsible name",
  "keyword": "Then "
});
formatter.match({
  "location": "com.vytrack.step_definitions.VehiclesStepDefs.the_user_clicks_the_vehicle_contract_has_responsible_name(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the information for the vehicle contract has \"Marc\" responsible name is same with the database",
  "keyword": "And "
});
formatter.match({
  "location": "com.vytrack.step_definitions.VehiclesStepDefs.the_information_for_the_vehicle_contract_has_responsible_name_is_same_with_the_database(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});