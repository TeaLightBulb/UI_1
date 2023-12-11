# UI_1
Login Interface via Andoid studio

*********

Login-on-android
This ia a project based on the login part of an android app
The code is written using android studio text editor
XML is used for the front end and JAVA is used for the back end code

*** Flowchart of the code ***
SignupActivity -> Takes input -> Stores the data in an XML file ->
HomeActivity -> Fetches data from the XML file ( created in the SignupActivity ) -> Show few (user ID , profile pic etc.) items in the screen
*** Basics about the code ***
The app contains two Activities
1.SignupActivity 2.HomeActivity

****

First in the SignupActivity the user inputs some info like Username , Password etc. then the data is stored in an XML file .Then by clicking the "Next" button the Activity Shifts to the HomeActivity .In HomeActivity the Username and Profile picture taken from the XML file and shown in the display .
The app contains a complete Login and Logout function -- If the user login one time then the second time when user opens the app the app takes the user to the HomeActivity.

*** SignupActivity ***
The SignupActivity takes a.Name , b.Password , c.User Profile Pic as input from the user
Stores the data in an XML file

*** HomeActivity ***
In the Home Activity the username , profile pic are shown
This acticvity contains a logout button by just pressing that we can logout and go to the signup activity
