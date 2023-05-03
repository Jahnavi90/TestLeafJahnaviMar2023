Feature: Login to LeafTaps Application and Edit a Lead
Scenario Outline:
#Given Set browser as <browser>
Given Enter the username as DemoCSR
And Enter the password as crmsfa
Then Click on login button
And Click on the CRM/SFA Link
And Click on the Leads tab button
And Click on Find Leads button
And Click on the Phone tab
And Enter the PhoneNum as <phNum>
And Click on Find Leads
And Click on the first resulting Lead
And Click on Edit Button
And Enter the Company_Name as <upCname>
When Click on the Update button
Then Verify if the Lead is edited successfully <upCname>
Examples:
|phNum|upCname|
|89|Corpo|
|99|Qeagle|
|88|JT|