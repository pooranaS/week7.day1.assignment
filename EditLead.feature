Feature: Edit Lead Fuctionality

Background:
Given Open new Chrome browser
And Load Application URL

Scenario: Edit Lead Scenario
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
And Click on Edit button
And Update CompanyName as 'TCS'
And Click on update button
Then Verify Updated record is available