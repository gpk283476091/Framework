package org.locators;

import org.base.BaaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdacitinSearchHotel extends BaaseClass {

	public AdacitinSearchHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement dDnLocation;

	@FindBy(id = "hotels")
	private WebElement dDnHotels;

	@FindBy(id = "room_type")
	private WebElement dDnRoomType;

	@FindBy(id = "room_nos")
	private WebElement dDnRoomNo;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;

	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;

	@FindBy(id = "adult_room")
	private WebElement dDnAdultsPerRoom;

	@FindBy(id = "child_room")
	private WebElement dDnChildrenPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSearch;
	
	@FindBy(xpath="//span[@id='checkin_span']")
	private WebElement errorCheckInMsg;
	
	@FindBy(id="checkout_span")
	private WebElement errorCheckOutMsg;
	
	@FindBy(id="location_span")
	private WebElement errorLocationMsg;

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoomNo() {
		return dDnRoomNo;
	}

	public WebElement gettxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement gettxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getdDnAdultsPerRoom() {
		return dDnAdultsPerRoom;
	}

	public WebElement getdDnChildrenPerRoom() {
		return dDnChildrenPerRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	public WebElement getErrorCheckInMsg() {
		return errorCheckInMsg;
	}

	public WebElement getErrorCheckOutMsg() {
		return errorCheckOutMsg;
	}

	public WebElement getErrorLocationMsg() {
		return errorLocationMsg;
	}

	public void dateCheck(String txtCheckInDate, String txtCheckOutDate) {
		clear(gettxtCheckInDate());
		enterText(gettxtCheckInDate(), txtCheckInDate);
		clear(gettxtCheckOutDate());
		enterText(gettxtCheckOutDate(), txtCheckOutDate);
	}

	public void completeFields(String Location,String Hotels,String RoomType, String NumberOfRooms, String txtCheckInDate, String txtCheckOutDate,
			String AdultsPerRoom, String ChildrenPerRoom) {
		visibleText(getdDnHotels(), Hotels);
		visibleText(getdDnRoomType(), RoomType);
		visibleText(getdDnChildrenPerRoom(), ChildrenPerRoom);
		mandatoryField(Location, NumberOfRooms, txtCheckInDate, txtCheckOutDate, AdultsPerRoom);
		

	}

	public void mandatoryField(String Location, String NumberOfRooms, String txtCheckInDate, String txtCheckOutDate,
			String AdultsPerRoom) {
		visibleText(getdDnLocation(), Location);
		visibleText(getdDnRoomNo(), NumberOfRooms);
		dateCheck(txtCheckInDate, txtCheckOutDate);
		visibleText(getdDnAdultsPerRoom(), AdultsPerRoom);
		click();
	}

	public void click() {
		btnClick(getBtnSearch());
	}
	

}
