Feature: Duplicate Lead Fuctionality

Scenario: Duplicate Lead Scenario
Given Open new Chrome browser
And Load Application URL
And Enter the Username as 'Demosalesmanager'
And Enter the Password as 'crmsfa'
When Click Login button
Given Click on CRMSFA link
And Click on Leads button
And Click on FindLeads link
And Click on phoneNumber tab
And Enter PhoneNumber as '99'
And Click on FindLeads button
And Click on FirstLead
And Click on Duplicate Lead button
And Click on CreateLead button
Then Verify Lead is created