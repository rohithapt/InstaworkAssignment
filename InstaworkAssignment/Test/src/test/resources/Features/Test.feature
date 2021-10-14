@FlightBooking
Feature: Verification of Flight Booking

  @FlightTest
  Scenario: Verification of Flight Booking
  Given user is in Flight booking application
  And the user selects the flight option and Round trip
  When the user selects "Leaving from"
  Then the user is provided with search option
  When the user search with "San Francisco"
  Then the user is provided with search result
    When the user selects "Going to"
    Then the user is provided with search option
    When the user search with "New York"
    Then the user is provided with search results
    And the user selects the Departing date
    And the user selects the Returning date
    When the user search the flight option
    Then the user is provided with the flight options
    When the user selects sort by "Price (Highest)" and "Nonstop" option from the filter
    Then the user is provided with the flight options


