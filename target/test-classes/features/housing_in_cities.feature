Feature: Searhing housing in different cities 
@UI
Scenario: Verify user can search housing in difrent cities 
	Given the user is on fourstay home page 
	When user clicks on the city name he/she wants 
	Then advanced search page opens 
	
@UI 
Scenario: Verify user can select by city name 
	Given the user is on fourstay home page 
	When user clicks on the desired city name 
	Then advanced search page opens 
	
@UI 
Scenario Outline: Verify user can select list of cities 
	Given the user is on fourstay home page 
	When user clicks on "<city>" 
	Then advanced search page opens 
	
	Examples: 
		|city|
		|BOSTON|
		|LOS-ANGELES|
		|SEATTLE|
		|CHICAGO|