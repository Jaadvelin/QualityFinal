 Feature: LogIn and LogOut
 
 Scenario: Client log out
  	Given the user accesses secure area
	When the user is not logged in
	Then she sees "You must login to view the secure area!"
  	
  	