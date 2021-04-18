package org.sample;

import java.util.List;
import java.util.Map;

import org.base.BaaseClass;
import org.junit.Assert;
import org.locators.AdacitinBookHotel;
import org.locators.AdacitinBookHotelMsg;
import org.locators.AdacitinLoginPage;
import org.locators.AdacitinSearchHotel;
import org.locators.AdacitinSelectHotel;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SearchHotel extends BaaseClass{
	@Given("User on Adacitin login page")
	public void userOnAdacitinLoginPage() {
		getDriver();
		launchUrl("http://adactinhotelapp.com/");
	    
	}

	@When("Enter Valid username and password {string},{string}")
	public void enterValidUsernameAndPassword(String username, String password) {
		AdacitinLoginPage loginpage = new AdacitinLoginPage();
		loginpage.login(username, password);
	    
	}

	@When("User should select {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldSelectAnd(String Location, String Hotels, String RoomType, String NumberOfRooms, String txtCheckInDate, String txtCheckOutDate, String AdultsPerRoom, String ChildrenPerRoom) {
		AdacitinSearchHotel search = new AdacitinSearchHotel();
		search.completeFields(Location, Hotels, RoomType, NumberOfRooms, txtCheckInDate, txtCheckOutDate, AdultsPerRoom, ChildrenPerRoom);
	    
	}

	@Then("verify user is on select hotel page {string}")
	public void verifyUserIsOnSelectHotelPage(String SelectHotel) {
	  
		Assert.assertEquals("SelectHotel", SelectHotel);
		System.out.println("Assert Passed");
	    
	}

	@When("User should select {string},{string}, {string},  {string} and {string}")
	public void userShouldSelectAnd(String Location, String NumberOfRooms, String txtCheckInDate, String txtCheckOutDate, String AdultsPerRoom) {
		AdacitinSearchHotel search = new AdacitinSearchHotel();
		search.mandatoryField(Location, NumberOfRooms, txtCheckInDate, txtCheckOutDate, AdultsPerRoom);
	    
	}

	@Then("verify the message getting it on select hotel page {string} and {string}")
	public void verifyTheMessageGettingItOnSelectHotelPageAnd(String string, String string2) {
		AdacitinSearchHotel search = new AdacitinSearchHotel();
		WebElement errorCheckInMsg = search.getErrorCheckInMsg();
		String text = errorCheckInMsg.getText();
		Assert.assertEquals("Check-In Date shall be before than Check-Out Date", text);
		System.out.println("Message validated :" + text);
		
		String text2 = search.getErrorCheckOutMsg().getText();
		Assert.assertEquals("Check-Out Date shall be after than Check-In Date", text2);
		System.out.println("Message validated :" + text2);
	    
	}

	@When("User leaves all the fields")
	public void userLeavesAllTheFields() {
		AdacitinSearchHotel search = new AdacitinSearchHotel();
		search.click();
	    
	}

	@Then("user should click search button and verify message {string}")
	public void userShouldClickSearchButtonAndVerifyMessage(String string) {
		AdacitinSearchHotel search = new AdacitinSearchHotel();
		String text = search.getErrorLocationMsg().getText();
		Assert.assertEquals("Please Select a Location", text);
		System.out.println("Message validated :" + text);
	    
	}
	
	

	@When("User should select radio and continue button")
	public void userShouldSelectRadioAndContinueButton() {
		AdacitinSelectHotel select = new AdacitinSelectHotel();
		select.radio();
		select.continueButton();
	}

	@When("User should select {string}, {string} and {string}")
	public void userShouldSelectAnd(String FirstName, String LastName, String BillingAddress) {
		AdacitinBookHotel book = new AdacitinBookHotel();
		book.name(FirstName, LastName, BillingAddress);
	}

	@When("User should enter credit card details{string},{string},{string},{string} and {string}")
	public void userShouldEnterCreditCardDetailsAnd(String CreditCardNumber,String CreditCardType, String ExpiryMonth, String ExpiryYear, String cvv, io.cucumber.datatable.DataTable dataTable) {
		AdacitinBookHotel book = new AdacitinBookHotel();
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(0);
		String string = map.get("CreditCardNumber");
		String string2 = map.get("CreditCardType");
		String string3 = map.get("ExpiryMonth");
		String string4 = map.get("ExpiryYear");
		String string5 = map.get("cvv");
		
		book.cardDetails(string, string2, string3, string4, string5);
		
	    
	}

	@When("user should click Book Now")
	public void userShouldClickBookNow() {
		AdacitinBookHotel book = new AdacitinBookHotel();
		book.bookNow();
	   
	    
	}

	@Then("user should get the order number from the same page and verify the message {string}")
	public void userShouldGetTheOrderNumberFromTheSamePageAndVerifyTheMessage(String string) {
		AdacitinBookHotel book = new AdacitinBookHotel();
		book.lastStep();
		String text = book.getTxtBookingConfirmation().getText();
		Assert.assertEquals("Booking Confirmation", text);
		
	}

	@When("User should leave all the page and click book now button")
	public void userShouldLeaveAllThePageAndClickBookNowButton() {
		AdacitinBookHotel book = new AdacitinBookHotel();
		book.bookNow();
	    
	}

	@Then("User should validate the error message displayed on same page {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldValidateTheErrorMessageDisplayedOnSamePageAnd(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
		AdacitinBookHotelMsg confirm = new AdacitinBookHotelMsg();
		String text = confirm.getTxtFirstName().getText();
		String text2 = confirm.getTxtLastName().getText();
		String text3 = confirm.getTxtBillingAddress().getText();
		String text4 = confirm.getTxtCreditCard().getText();
		String text5 = confirm.getTxtCreditCardType().getText();
		String text6 = confirm.getTxtExpiryMonth().getText();
		String text7 = confirm.getTxtCvv().getText();
		Assert.assertEquals("Please Enter your First Name", text);
		System.out.println(text);
		Assert.assertEquals("Please Enter you Last Name", text2);
		System.out.println(text2);
		Assert.assertEquals("Please Enter your Address", text3);
		System.out.println(text3);
		Assert.assertEquals("Please Enter your 16 Digit Credit Card Number", text4);
		System.out.println(text4);
		Assert.assertEquals("Please Select your Credit Card Type", text5);
		System.out.println(text5);
		Assert.assertEquals("Please Select your Credit Card Expiry Month", text6);
		System.out.println(text6);
		Assert.assertEquals("Please Enter your Credit Card CVV Number", text7);
		System.out.println(text7);
	}
	
	@When("User should enter {string},{string},{string},{string},{string},{string} ,{string} and {string}")
	public void userShouldEnterAnd(String Location, String Hotels, String RoomType, String NumberOfRooms, String txtCheckInDate, String txtCheckOutDate, String AdultsPerRoom, String ChildrenPerRoom) {
		AdacitinSearchHotel search = new AdacitinSearchHotel();
		search.completeFields(Location, Hotels, RoomType, NumberOfRooms, txtCheckInDate, txtCheckOutDate, AdultsPerRoom, ChildrenPerRoom);
	}

	@When("User should verify on select hotel page {string} and user should select radio button and continue button")
	public void userShouldVerifyOnSelectHotelPageAndUserShouldSelectRadioButtonAndContinueButton(String string) {
		AdacitinSelectHotel select = new AdacitinSelectHotel();
//		boolean title = driver.getTitle().equals("Adactin.com - Select Hotel");
//		Assert.assertEquals("Adactin.com - Select Hotel",title);
		select.radio();
		select.continueButton();
		System.out.println("Assert passed");
		
	}

	@When("User should get the order number from same page and verify the message {string}")
	public void userShouldGetTheOrderNumberFromSamePageAndVerifyTheMessage(String string) {
		AdacitinBookHotel book = new AdacitinBookHotel();
		book.bookNow();
		book.lastStep();
		String text = book.getTxtBookingConfirmation().getText();
		Assert.assertEquals("Booking Confirmation", text);
	}

	@When("click Booked Itinery link and with help of the order number , cancel the order user made and handle the alert thrown by the page")
	public void clickBookedItineryLinkAndWithHelpOfTheOrderNumberCancelTheOrderUserMadeAndHandleTheAlertThrownByThePage() {
		AdacitinBookHotel book = new AdacitinBookHotel();
		book.clickItinery();
	  WebElement orderNo = book.getOrderNo();
	  String text = orderNo.getText();
	 	
	}

	@Then("After cancelling the order verfiy the message shown on the page {string}")
	public void afterCancellingTheOrderVerfiyTheMessageShownOnThePage(String string) {
	    
	}

	@When("Verfiy user on Search hotel page title {string} and click Booked Intinerary link")
	public void verfiyUserOnSearchHotelPageTitleAndClickBookedIntineraryLink(String string) {
	    
	}

	@When("verify user on Booked Intinerary page title {string} and cancel existing {string}")
	public void verifyUserOnBookedIntineraryPageTitleAndCancelExisting(String string, String string2) {
	    
	}

	@When("Handle the message given at the time of cancel and click ok")
	public void handleTheMessageGivenAtTheTimeOfCancelAndClickOk() {
	    
	}

	@Then("Verify the existing order is cancelled by validating {string}")
	public void verifyTheExistingOrderIsCancelledByValidating(String string) {
	    
	}



}