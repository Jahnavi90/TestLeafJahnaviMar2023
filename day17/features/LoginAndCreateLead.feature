Feature: Login to LeafTaps Application
Scenario: To be able to login into the application and create a Lead successfully.
Given Launch Browser, add implicit wait, load the URL, maximize the screen.
And Enter the Username as 'DemoCsr'
And Enter the Password as 'crmsfa'
When Click on Login button
And Click on CRM/SFA Link
And Click on Leads tab button
And Click on the Create button
And Enter the Company Name as TCS
And Enter the FirstName as Jahnavi
And Enter the LastName as Aradhyula
And Enter the Phone Number 9884653533
When Click on Submit button
Then Verify if the Lead is successfully created
And Close the Browser

Scenario: Verify login - negative scenario
Given Launch Browser, add implicit wait, load the URL, maximize the screen.
And Enter the Username as 'DemoCs2'
And Enter the Password as 'crmsfa'
When Click on Login button
But Login fails