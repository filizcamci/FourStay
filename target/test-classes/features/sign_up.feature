Feature: new user registration

Scenario: new user registration negative
Given the user is on the homepage
When the user enters valid email and password
When the user enters the phone number taken before
Then "phone has already been taken" message should be displayed
