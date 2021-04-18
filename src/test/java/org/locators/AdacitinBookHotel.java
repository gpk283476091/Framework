package org.locators;

import org.base.BaaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdacitinBookHotel extends BaaseClass {
public AdacitinBookHotel() {

PageFactory.initElements(driver, this);
}

@FindBy(id="first_name")
private WebElement txtFirstName;

@FindBy(id="last_name")
private WebElement txtLastName;

@FindBy(id="address")
private WebElement txtBillingAddress;

@FindBy(id="cc_num")
private WebElement dDnCreditCardNumber;

@FindBy(id="cc_type")
private WebElement dDNCreditCardType;

@FindBy(id="cc_exp_month")
private WebElement DdnExpiryDate;

@FindBy(id="cc_exp_year")
private WebElement dDnExpiryYear;

@FindBy(id="cc_cvv")
private WebElement txtCVV;

@FindBy(id="book_now")
private WebElement btnBooknow;

@FindBy(id="order_no")
private WebElement orderNo;

@FindBy(xpath="//td[@class='login_title']")
private WebElement txtBookingConfirmation;

@FindBy(xpath="//a[text()='Booked Itinerary']")
private WebElement linkBookedItinery;

public WebElement getLinkBookedItinery() {
	return linkBookedItinery;
}

public WebElement getOrderNo() {
	return orderNo;
}

public WebElement getTxtFirstName() {
	return txtFirstName;
}

public WebElement getTxtLastName() {
	return txtLastName;
}

public WebElement getTxtBillingAddress() {
	return txtBillingAddress;
}

public WebElement getdDnCreditCardNumber() {
	return dDnCreditCardNumber;
}

public WebElement getdDNCreditCardType() {
	return dDNCreditCardType;
}

public WebElement getDdnExpiryDate() {
	return DdnExpiryDate;
}

public WebElement getdDnExpiryYear() {
	return dDnExpiryYear;
}

public WebElement getTxtCVV() {
	return txtCVV;
}

public WebElement getBtnBooknow() {
	return btnBooknow;
}

public WebElement getTxtBookingConfirmation() {
	return txtBookingConfirmation;
}


public void name(String FirstName, String LastName, String BillingAddress) {
	enterText(getTxtFirstName(), FirstName);
	enterText(getTxtLastName(), LastName);
	enterText(getTxtBillingAddress(), BillingAddress);
}

public void cardDetails(String CreditCardNumber,String CreditCardType, String ExpiryMonth, String ExpiryYear, String cvv) {
	enterText(getdDnCreditCardNumber(), CreditCardNumber);
	visibleText(getdDNCreditCardType(), CreditCardType);
	visibleText(getDdnExpiryDate(), ExpiryMonth);
	visibleText(getdDnExpiryYear(), ExpiryYear);
	enterText(getTxtCVV(), cvv);
}
public void booking(String FirstName, String LastName, String BillingAddress, String CreditCardNumber,String CreditCardType, String ExpiryMonth, String ExpiryYear, String cvv) {
name(FirstName, LastName, BillingAddress);
cardDetails(CreditCardNumber, CreditCardType, ExpiryMonth, ExpiryYear, cvv);
bookNow();
}

public void bookNow() {
btnClick(getBtnBooknow());
}

public void lastStep() {
implicitWait(30);
javaScriptScrollDown(getOrderNo());
getAttribute(getOrderNo());

}

public void ordernoVerification() {
	WebElement orderNo2 = getOrderNo();
	String text = orderNo2.getText();
	System.out.println("Order number is :" + text);

}

public void clickItinery() {
btnClick(getLinkBookedItinery());
}


}




