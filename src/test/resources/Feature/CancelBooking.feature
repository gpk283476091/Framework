Feature: Verifying Adacitinhotel app with multiple scenarios

  #scenario 1
  @reg
  Scenario Outline: Book a hotel and cancel the booking user made
    Given User on Adacitin login page
    When Enter Valid username and password "<UserName>","<Password>"
    When User should enter "<Location>","<Hotels>","<RoomType>","<NumberOfRooms>","<CheckInDate>","<CheckOutDate>" ,"<AdultsPerRoom>" and "<ChildrenPerRoom>"
    And User should verify on select hotel page "Adactin.com - Select Hotel" and user should select radio button and continue button
    And User should select "<FirstName>", "<LastName>" and "<BillingAddress>"
    And User should enter credit card details"<CreditCardNumber>","<CreditCardType>","<ExpiryMonth>","<ExpiryYear>" and "<cvv>"
      | CreditCardNumber | CreditCardType   | ExpiryMonth | ExpiryYear | cvv |
      | 4569789665891598 | VISA             | December    |       2022 | 123 |
      | 4569789665891264 | Master Card      | January     |       2022 | 123 |
      | 4569789664598687 | American Express | December    |       2025 | 123 |
    And User should get the order number from same page and verify the message "Booking Confirmation"
    And click Booked Itinery link and with help of the order number , cancel the order user made and handle the alert thrown by the page
    Then After cancelling the order verfiy the message shown on the page "The booking has been cancelled."

    Examples: 
      | UserName         | Password | Location | Hotels         | RoomType | NumberOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom | FirstName | LastName | BillingAddress   |
      | jerrykarthikeyan | qwerty   | Sydney   | Hotel Sunshine | Double   | 10 - Ten      | 07/04/2021  | 08/04/2021   | 1 - One       | 3 - Three       | Yasodaha  | K        | Mosakuttipalayam |

  #scenario 2
  Scenario Outline: Cancel the existing order id
    Given User on Adacitin login page
    When Enter Valid username and password "<UserName>","<Password>"
    And Verfiy user on Search hotel page title "SearchHotel" and click Booked Intinerary link
    And verify user on Booked Intinerary page title "BookedItinerary" and cancel existing "<Order Id>"
    And Handle the message given at the time of cancel and click ok
    Then Verify the existing order is cancelled by validating "The booking has been cancelled."

    Examples: 
      | UserName         | Password | Order Id   |
      | jerrykarthikeyan | qwerty   | FX5G15ZGP1 |
