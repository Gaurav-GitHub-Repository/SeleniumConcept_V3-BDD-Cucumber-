
@FunctionalTest
Feature: Verify registration form
Scenario: Verify name, email, phone and address in registration form

Background: launch browser and navigate to Url
 
And : User is on dashboard page
When : Verify name, email, phone and address 
Then : Regsitration form is verified

Examples:
|name|email|phone|address|
|abc|abc@gmail.com|123|Address|