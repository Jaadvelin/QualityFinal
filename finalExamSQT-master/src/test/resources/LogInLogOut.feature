Feature: LogIn and LogOut
 

  Scenario: Client logins with invalid credentials
  	Given the user is on the login page
  	When she fills in "username" with "tomsmith"
  	And she fills in "password" with "wrong"
  	And she presses "Login"
  	Then she is on the login page
  	And she sees "Your password is invalid!" 
