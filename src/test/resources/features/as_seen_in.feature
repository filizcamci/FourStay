@regression
Feature: Correct websites open after clicking links 


Scenario Outline: Verify that correct websites open after clicking links 
	Given the user is on fourstay home page 
	When user clicks on <as seen> link 
	Then correct <website> opens 
		|website|<url>|
	Examples: 
		|as seen|url|
		|Business Journal|https://www.bizjournals.com/washington/news/2016/10/21/startup-of-the-week-4stay-wants-to-connect.html|
		|Forbes|https://fourstay-staging.herokuapp.com/#|
		|Bisnow|https://www.bisnow.com/washington-dc/news/neighborhood/meet-the-five-disruptive-companies-establishing-crystal-city-as-premier-nexus-of-innovation-66768#0|
		|Study Usa|https://www.studyusa.com/en/blog/1050/escape-the-dorm-doom-with-4stay|
		|Arl now|https://www.arlnow.com/2017/04/03/making-the-student-housing-search-easier-with-4stay/|
 
Scenario Outline: Verify that correct websites open after clicking right link 
	Given the user is on fourstay home page 
	When user clicks on <index> of the "<as seen>" link 
	Then correct <website> opens 
		|website|<url>|
	Examples: 
		|index|as seen			|url|
		|1	  |Business Journal |https://www.bizjournals.com/washington/news/2016/10/21/startup-of-the-week-4stay-wants-to-connect.html|
		|2	  |Forbes		    |https://fourstay-staging.herokuapp.com/#|
		|3	  |Bisnow			|https://www.bisnow.com/washington-dc/news/neighborhood/meet-the-five-disruptive-companies-establishing-crystal-city-as-premier-nexus-of-innovation-66768#0|
		|4	  |Study Usa		|https://www.studyusa.com/en/blog/1050/escape-the-dorm-doom-with-4stay|
		|5	  |Arl now			|https://www.arlnow.com/2017/04/03/making-the-student-housing-search-easier-with-4stay/|