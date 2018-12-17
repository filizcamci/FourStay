Feature: Listing the stays


Scenario: Verify user can login before listing stays 
Given the user is on fourstay home page
When user clicks on list your stay button
Then sign-up/sign-in page opens
When user clicks on login here link
Then login pop-up opens
