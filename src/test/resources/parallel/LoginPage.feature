@Login
Feature: Login page feature


Background: Launching Login App
     Given I am on the login page


Scenario: Login with correct credentials    
    When I login with "user123" and "happycoder123"
    Then I should see a message saying "Login Successfull" near Password field

 Scenario: Login with Blank Username and Blank Password
   When I login with "" and ""
   Then I should see a message saying "Name cannot be blank" near Name field
   Then I should see a message saying "Password cannot be blank" near Password field

 Scenario: Login with some Username and Blank Password
   When I login with "user123" and ""
   Then I should see a message saying "Password cannot be blank" near Password field

 Scenario: Login with some Username and Password less than Eight characters
   When I login with "user123" and "happy"
   Then I should see a message saying "Password must be longer than 8 characters" near Password field

 Scenario: Login with some Username and Password more than Fifteen characters
   When I login with "user123" and "happycoder123happycoder123happycoder123"
   Then I should see a message saying "Password must be shorter than 15 characters" near Password field

 Scenario: Login with some Username and Password within acceptable number of characters
   When I login with "user123" and "happycoder12"
   Then I should see a message saying "Nice try !!! but credentials are wrong" near Password field
   
 Scenario: Login with some Username and Password within acceptable number of characters - Intentially failing
   When I login with "user123" and "happycoder123"
   Then I should see a message saying "Nice try !!! but credentials are wrong" near Password field
