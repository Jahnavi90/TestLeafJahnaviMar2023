Feature: To be able delete an individual in the SalesForce Application

Scenario Outline:
Given Enter Username as jahnavi90@tcs.com
And Enter password as SaiBaba@143$
And Click on login button
And Click the toggle menu in the Home Page
And Click on View All button
And In the toggle Menu click on Individuals
Given Provide the lname as <lname>
And Select the delete from the dropdown
And Click on Delete button
And Verify if the lname is deleted <lname>

Examples:
|lname|
|Jonnavithula|