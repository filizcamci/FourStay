Feature: Fourstay login window 
@homepage @smoke
Scenario: Email field should be displayed 
	Given the user is on fourstay home page 
	When the user clicks on the login link 
	Then the email field should be displayed 