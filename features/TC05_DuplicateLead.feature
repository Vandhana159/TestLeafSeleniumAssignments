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

When Click on Create Lead
Then Navigated to create lead page

Given Enter CompanyName and FirstName and LastName and LocalFirstName and Department and Description and email
Given Select State as NewYork

When Click on Create button
Then Verify the title of the page

And Click Duplicate Lead
Given Verify title as Duplicate Lead
Then Clear the CompanyName Field using .clear() and Enter new CompanyName
And Clear the FirstName Field using .clear() and Enter new FirstName

When Click on Create Lead
Then Navigated to create lead page
And Verify Company Name and FirstName
Given Close the browser
