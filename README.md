# UI_1
Login Interface via Andoid studio

*********

Login-on-android  </br>
This ia a project based on the login part of an android app  </br>
The code is written using android studio text editor  </br>
XML is used for the front end and JAVA is used for the back end code  </br>

*** Flowchart of the code ***  </br>
SignupActivity -> Takes input -> Stores the data in an XML file ->  </br>
HomeActivity -> Fetches data from the XML file ( created in the SignupActivity ) -> Show few (user ID , profile pic etc.) items in the screen  </br>
*** Basics about the code ***  </br>
The app contains two Activities  </br>
1.SignupActivity 2.HomeActivity  </br>

****

First in the SignupActivity the user inputs some info like Username , Password etc. then the data is stored in an XML file .Then by clicking the "Next" button the Activity Shifts to the HomeActivity .In HomeActivity the Username and Profile picture taken from the XML file and shown in the display .  </br>
The app contains a complete Login and Logout function -- If the user login one time then the second time when user opens the app the app takes the user to the HomeActivity.  </br>

*** SignupActivity ***  </br>
The SignupActivity takes a.Name , b.Password , c.User Profile Pic as input from the user  </br>
Stores the data in an XML file  </br>

*** HomeActivity ***  </br>
In the Home Activity the username , profile pic are shown  </br>
This acticvity contains a logout button by just pressing that we can logout and go to the signup activity  </br>
