 Feature: LogIn and LogOut
 
 Scenario: Client log out
  	Given the user is already logged in
	When the user presses "logout"
	Then she is on the login page
  	
  	