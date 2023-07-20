Feature: Functionality of delete lead in leaf taps application

Scenario: Deleting leads using phone number

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
Given Click on Phone
Given Enter phone number
Given Click Find leads button
Given Capture lead ID of First Resulting lead
Given Click First Resulting lead
Given Click on Delete
Given Click Find leads
Given Enter captured lead ID
Given Click Find leads button
Given Verify message No records to display in the Lead List. This message confirms the successful deletion
Given Close the browser
		