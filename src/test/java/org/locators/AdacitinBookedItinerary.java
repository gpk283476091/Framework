package org.locators;

import org.base.BaaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdacitinBookedItinerary extends BaaseClass {
public AdacitinBookedItinerary() {
	PageFactory.initElements(driver, this);
}
@FindBy(id="order_id_text")
private WebElement txtSearchOrderId;

@FindBy(id="search_hotel_id")
private WebElement clkClick;

public WebElement getTxtSearchOrderId() {
	return txtSearchOrderId;
}

public WebElement getClkClick() {
	return clkClick;
}

public void valueAndClick() {
	AdacitinBookHotel book = new AdacitinBookHotel();
	
enterText(getTxtSearchOrderId(), null);
	
}


}
