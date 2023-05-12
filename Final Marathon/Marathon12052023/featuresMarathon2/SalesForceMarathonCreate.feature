Feature: To be able create an individual in the SalesForce Application

Background:
Given Enter Username as jahnavi90@tcs.com
And Enter password as SaiBaba@143$
And Click on login button
And Click the toggle menu in the Home Page
And Click on View All button

Scenario Outline:
And In the toggle Menu click on Individuals
And Click on New Individual
And Provide the last Name value as <lname>
Then Click on Save button
And Verify the Individual info

Examples:
|lname|
|Aradhyula|
|Veturi|
|Jonnavithula|