Feature: Verfifying Adacitin select hotel page with multiple scenarios

  #scenario 1
  Scenario Outline: Need to enter all fields and verify navigating to select hotel page
    Given User on Adacitin login page
    When Enter Valid username and password "<UserName>","<Password>"
    And User should select "<Location>","<Hotels>","<RoomType>","<NumberOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    Then verify user is on select hotel page "SelectHotel"

    Examples: 
      | UserName         | Password | Location | Hotels         | RoomType | NumberOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | jerrykarthikeyan | qwerty   | Sydney   | Hotel Sunshine | Double   | 10 - Ten      | 07/04/2021  | 08/04/2021   | 1 - One       | 3 - Three       |

  #scenario 2
  Scenario Outline: Enter only mandatory fields and verify navigating to select hotel page
    Given User on Adacitin login page
    When Enter Valid username and password "<UserName>","<Password>"
    And User should select "<Location>","<NumberOfRooms>", "<CheckInDate>",  "<CheckOutDate>" and "<AdultsPerRoom>"
    Then verify user is on select hotel page "SelectHotel"

    Examples: 
      | UserName         | Password | Location | NumberOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | jerrykarthikeyan | qwerty   | Sydney   | 10 - Ten      | 07/04/2021  | 08/04/2021   | 1 - One       | 3 - Three       |

  #scenario3
  Scenario Outline: Enter the invalid checkin date and checkout date
    Given User on Adacitin login page
    When Enter Valid username and password "<UserName>","<Password>"
    And User should select "<Location>","<NumberOfRooms>", "<CheckInDate>",  "<CheckOutDate>" and "<AdultsPerRoom>"
    Then verify the message getting it on select hotel page "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | UserName         | Password | Location | NumberOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | jerrykarthikeyan | qwerty   | Sydney   | 10 - Ten      | 14/04/2021  | 13/04/2021   | 1 - One       | 3 - Three       |

  #scenario 4
  Scenario Outline: Leave all the fields and click search button
    Given User on Adacitin login page
    When Enter Valid username and password "<UserName>","<Password>"
    And User leaves all the fields
    Then user should click search button and verify message "Please Select a Location"

    Examples: 
      | UserName         | Password |
      | jerrykarthikeyan | qwerty   |
