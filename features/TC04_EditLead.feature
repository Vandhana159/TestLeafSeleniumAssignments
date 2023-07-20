Feature: Functionality of edit lead in leaf taps application

Scenario: Edit leads using phone number

Given Launch the Web browser
Given Launch the leaftaps url
Given Enter username,password
And Click on Login button

Then Navigated to second Login page
Given Click on CRMSFA Link
Then HomePage is displayed
Given Click Leads link
Then Leads page is displayed
Given Click Find leads
Given Enter first name
Given Click Find leads button
Given Capture lead ID of First Resulting lead
Given Click First Resulting lead
Given Verify title of the page
Given Click Edit
Given Change the company name
Given Click Update
Given Confirm the changed name appears
Given Close the browser