Feature: Login to SalesForce Application
Scenario: To be able to login into the application and create an Opportunity successfully.
Given Launch SalesForce Browser, add implicit wait, load the URL, maximize the screen.
And Enter the Username in the text box as hari.radhakrishnan@qeagle.com
And Enter the Password in the text box as Leaf@1234
When Click on Login button in the application
And Click on the toggle menu button in the left corner
And Click on view All
And Click on Sales from App Launcher
And Click on Opportunities
And Click on New
And Enter a name in Opportunity name text box as Salesforce Automation by Jahnavi and verify the text that is entered
And Select close date as today's date
And Select Stage field as Needs Analysis
When Click on the Submit button
Then Verify if the Opportunity is successfully created
And Close the SalesForce Browser