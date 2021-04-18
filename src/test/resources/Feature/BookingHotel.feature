Feature: Verfifying Adacitin Booking page with multiple scenarios
@smoke
  #scenario 1
  Scenario Outline: Need to enter all fields and verify Booking confirmation
    Given User on Adacitin login page
    When Enter Valid username and password "<UserName>","<Password>"
    And User should select "<Location>","<Hotels>","<RoomType>","<NumberOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    
    And User should select radio and continue button
    And User should select "<FirstName>", "<LastName>" and "<BillingAddress>"
    And User should enter credit card details"<CreditCardNumber>","<CreditCardType>","<ExpiryMonth>","<ExpiryYear>" and "<cvv>"
      | CreditCardNumber | CreditCardType   | ExpiryMonth | ExpiryYear | cvv |
      | 4569789665891598 | VISA             | December    |       2022 | 123 |
      | 4569789665891264 | Master Card      | January     |       2022 | 123 |
      | 4569789664598687 | American Express | December    |       2025 | 123 |
    And user should click Book Now
    Then user should get the order number from the same page and verify the message "Booking Confirmation"

    Examples: 
      | UserName         | Password | Location | Hotels         | RoomType | NumberOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom | FirstName | LastName | BillingAddress   |
      | jerrykarthikeyan | qwerty   | Sydney   | Hotel Sunshine | Double   | 10 - Ten      | 07/04/2021  | 08/04/2021   | 1 - One       | 3 - Three       | Yasodaha  | K        | Mosakuttipalayam |

  #scenario 2
  Scenario Outline: Need to enter all the fields on booking page and get the error message displayed
    Given User on Adacitin login page
    When Enter Valid username and password "<UserName>","<Password>"
    And User should select "<Location>","<Hotels>","<RoomType>","<NumberOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    
    And User should select radio and continue button
    And User should leave all the page and click book now button
    Then User should validate the error message displayed on same page "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | UserName         | Password | Location | Hotels         | RoomType | NumberOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | jerrykarthikeyan | qwerty   | Sydney   | Hotel Sunshine | Double   | 10 - Ten      | 07/04/2021  | 08/04/2021   | 1 - One       | 3 - Three       |
