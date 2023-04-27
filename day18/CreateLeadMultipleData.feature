Feature: Login to LeafTaps Application for Creating Lead with multiple data

#Background: 
#Given Launch the Browser, add implicit wait, load the URL, maximize the screen.

@Positive
Scenario Outline:
And Enter the username as 'DemoCsr'
And Enter the password as 'crmsfa'
When Click on login button
And Click on the CRM/SFA Link
And Click on the Leads tab button
And Click on Create button
And Enter the CompanyName as <cname>
And Enter the First Name as <fname>
And Enter the Last Name as <lname>
And Enter the PhoneNumber <phNum>
When Click on the final Submit button
Then Verify if the Lead is created successfully
Examples:
|cname|fname|lname|phNum|
|BNP|Padma|Mullapudi|9807678654|
|Infosys|Akhila|Kora|9087655676|
|TCS|Sumathi|Deva|9087342134|

@Negative
Scenario Outline:
And Enter the username as 'DemoCsr'
And Enter the password as 'crmsfa'
When Click on login button
And Click on the CRM/SFA Link
And Click on the Leads tab button
And Click on Create button
And Enter the CompanyName as <cname>
And Enter the First Name as <fname>
And Enter the Last Name as <lname>
And Enter the PhoneNumber <phNum>
When Click on the final Submit button
But Verify if the Lead is not created successfully
#And Close the opened Browser

Examples:
|cname|fname|lname|phNum|
|BNP||Mullapudi|9807678654|
|Infosys||Kora|9087655676|
||Sumathi|Deva|88|
