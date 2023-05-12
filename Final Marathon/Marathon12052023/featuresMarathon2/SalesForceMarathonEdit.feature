Feature: To be able edit an individual in the SalesForce Application

Scenario Outline:
Given Enter Username as jahnavi90@tcs.com
And Enter password as SaiBaba@143$
And Click on login button
And Click the toggle menu in the Home Page
And Click on View All button
And In the toggle Menu click on Individuals
Given Enter the value to edit as <lname>
And Click on the edit button
And Provide the firstname as <fname>
And Verify the edited info

Examples:
|lname|fname|
|Veturi|Karunya|
|Jonnavithula|Bhavagnyita|