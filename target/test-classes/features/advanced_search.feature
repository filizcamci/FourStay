Feature: Perform advanced search


Scenario: Verify user can do advanced search
Given the user is on fourstay home page
When user clicks on the desired city name 
Then advanced search page opens
And city name on the map matches the searched city name

@ws
Scenario: Get the text from google map api
Given the user is on fourstay home page
When user clicks on the desired city name 
Then advanced search page opens 
When the user gets map api url
Then user requests the text from map api
