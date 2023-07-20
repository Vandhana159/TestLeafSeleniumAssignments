Feature: Functionality of Login module(LeafTaps)

Scenario: Login with valid credentials and navigate to leads page

Given Launch the Web browser
Given Launch the leaftaps url
Given Enter username,password
And Click on Login button

Then Navigated to second Login page
Given Click on CRMSFA Link
Then HomePage is displayed
Given Click Leads link
Then Leads page is displayed
Then Verify the title of the page
Given Close the browser
