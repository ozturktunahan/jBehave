Meta:

Narrative: In order to Book a flight ticket with Source and Destination values
Scenario: As a user I should not be able select destination same as Source Location
Given I am in Istanbul
And I want to Book a Flight Ticket
When I choose my Source Location as Istanbul
Then My destination Location should not contain Istanbul as an option

Scenario: As a user I should be able select destination other than Source Location
Given I am in Istanbul
When I choose my Source Location as Istanbul
Then I choose my Destination Location as Ankara
