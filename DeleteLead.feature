Feature: Delete Lead Fuctionality

Background:
Given Open new Chrome browser
And Load Application URL

Scenario: Delete Lead Scenario
And Enter the Username as 'Demosalesmanager'
And Enter the Password as 'crmsfa'
When Click Login button
Given Click on CRMSFA link
And Click on Leads button
And Click on FindLeads link
And Click on phoneNumber tab
And Enter PhoneNumber as '9'
And Click on FindLeads button
And Click on FirstLead
And Click on Delete button
And Click on FindLeads link again
And Enter the FirstLead ID
And Click on FindLeads button again
Then Verify Deleted record is available