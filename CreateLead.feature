Feature: Create Lead Fuctionality

Background:
Given Open new Chrome browser
And Load Application URL

Scenario Outline: Create Lead Scenario
And Enter the Username as <username>
And Enter the Password as <password>
When Click Login button
Given Click on CRMSFA link
And Click on Leads button
And Click on CreateLead link
And Enter the companyName as <cName>
And Enter the firstName as <fName>
And Enter the lastName as <lName>
When click Submit button
Then ViewLead should  be dislayed

Examples:
|username|password|cName|fName|lName|
|'Demosalesmanager'|'crmsfa'|'NMS'|'Parvathi'|'Nagaraj'|
|'DemoCSR'|'crmsfa'|'IBM'|'Pavi'|'ArunKumar'|

Scenario: Login with Negative Credential

Given Open new Chrome browser
And Load Application URL
And Enter the Username as 'Demo'
And Enter the Password as 'crmsfa'
When Click Login button
But ErrorMessage should display