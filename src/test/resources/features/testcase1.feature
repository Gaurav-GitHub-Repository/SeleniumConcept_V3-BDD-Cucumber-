
@FunctionalTest
Feature: Verify GUI Elements text 
Scenario: Verify GUI Elements text is displayed in dashboard page

Background: launch browser and navigate to url
 
And : User is on dashboard page
When : Verify GUI Elements text in dashboard
Then : GUI Element text is verified