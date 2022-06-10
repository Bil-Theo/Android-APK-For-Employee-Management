This android application is developed under the androidStudio environment.
It contains activities, each activity of which consists of an interface (GUI) with file.xlm and java classes for its implementation.
To communicate with the database we used the rational data engine SQLite, which is a rational data manager integrated in each android phone.
For the tests we use an 8px tablet type virtual machine and a 6.5px Techno 3436 physical machine.

So among the activities, we find:

-The main activity which contains: a resource layout activity_main.xlm which will contain the home interface with an option menu which will be implemented in our MainActivity.java class by calling the menu resource which my_menu.xlm.

At each click of items in this menu, an operation will be performed. Among its operations we find, consult the list of employees, add employee, delete employee, modify employee and contact employer either by sms, by call, or by email.
