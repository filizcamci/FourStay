$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/messaging.feature");
formatter.feature({
  "name": "Message conversation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify that conversation box opens after clicking messenger",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@temp"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on fourstay home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HomepageEmailStepDefs.the_user_is_on_fourstay_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on message icon",
  "keyword": "When "
});
formatter.match({
  "location": "MessagingStepDefs.user_clicks_on_message_icon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "conversation box opens",
  "keyword": "Then "
});
formatter.match({
  "location": "MessagingStepDefs.conversation_box_opens()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});