Feature: LeafTaps Login Functionality

Scenario: Login with Positive Credential

Given Open the Chrome browser
And Load  Application URL
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click on Login button
Then HomePage should be displayed

Scenario: Login with Negative Credential

Given Open the Chrome browser
And Load  Application URL
And Enter the username as 'Demo'
And Enter the password as 'crmsfa'
When Click on Login button
But ErrorMessage should be displayed

Scenario Outline: Login with Positive Credential

Given Open the Chrome browser
And Load  Application URL
And Enter the username as <username>
And Enter the password as <password>
When Click on Login button
Then HomePage should be displayed

Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|