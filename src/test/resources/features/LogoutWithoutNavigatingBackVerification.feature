@wip
Feature: Default

	#User Story :As a user, I should be able to log out.
	#1- User can log out and ends up in login page.
	#2- The user can not go to the home page again by clicking the step back button after successfully logged out.
	@FIX10-370
	Scenario: Verify user CAN'T navigate back after logout
		Given user is on the login page
		When user enters username
		Then user enters password
		And clicks login button
		Then user logged in
		
		When user click logout select
		Then verify user at login page
		    
		When user navigates back
		Then verify user not in homepage