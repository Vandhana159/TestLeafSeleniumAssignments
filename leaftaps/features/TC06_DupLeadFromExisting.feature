Feature: Functionality of duplicate lead in leaf taps application

Scenario: Create duplicate leads using email id number

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
Given Click on Email tab
Then Enter Email 
Given Click Find leads button
Then Capture name of First Resulting lead
Given Click First Resulting lead
And Click Duplicate Lead
Given Verify title as Duplicate Lead
Then Click on Create button
And Confirm the duplicated lead name is same as captured name
Given Close the browser