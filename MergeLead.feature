Feature: Merge Lead Fuctionality

Background:
Given Open new Chrome browser
And Load Application URL

Scenario: Merge Lead Scenario
And Enter the Username as 'Demosalesmanager'
And Enter the Password as 'crmsfa'
When Click Login button
Given Click on CRMSFA link
And Click on Leads button
And Click on MergeLeads link
And Click on FromLead widget
And Enter From FirstName as 'Hari'
And Click on FindLeads button for FromLead
And Click on First FromLead
And Click on ToLead widget
And Enter To FirstName as 'R'
And Click on FindLeads button for ToLead
And Click on First ToLead
When Click on Merge button
Given Click on FindLeads link after Merging
And Enter the From FirstLead ID
And Click on FindLeads button for searching FirstLeadId
Then Verify Merged record is available