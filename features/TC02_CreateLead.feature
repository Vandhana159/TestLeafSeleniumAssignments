Feature: Functionality of create lead in leaf taps application

Scenario: Creating leads with only mandatory inputs

Given Launch the Web browser
Given Launch the leaftaps url
Given Enter username,password
And Click on Login button
Then Navigated to second Login page

Given Click on CRMSFA Link
Then HomePage is displayed

Given Click Leads link
Then Leads page is displayed

When Click on Create Lead
Then Navigated to create lead page

Given Enter CompanyName and FirstName and LastName and LocalFirstName and Department and Description and email
Given Select State as NewYork

When Click on Create button
Then Verify the title of the page

Given Close the browser
