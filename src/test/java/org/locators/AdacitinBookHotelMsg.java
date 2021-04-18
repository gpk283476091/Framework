package org.locators;

import org.base.BaaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdacitinBookHotelMsg extends BaaseClass{

	public AdacitinBookHotelMsg() {
PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="first_name_span")
	private WebElement txtFirstName;
	
	@FindBy(id="last_name_span")
	private WebElement txtLastName;
	
	@FindBy(id="address_span")
	private WebElement txtBillingAddress;
	
	@FindBy(id="cc_num_span")
	private WebElement txtCreditCard;
	
	@FindBy(id="cc_type_span")
	private WebElement txtCreditCardType;
	
	@FindBy(id="cc_expiry_span")
	private WebElement txtExpiryMonth;
	
	@FindBy(id="cc_cvv_span")
	private WebElement txtCvv;
	
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtBillingAddress() {
		return txtBillingAddress;
	}

	public WebElement getTxtCreditCard() {
		return txtCreditCard;
	}

	public WebElement getTxtCreditCardType() {
		return txtCreditCardType;
	}

	public WebElement getTxtExpiryMonth() {
		return txtExpiryMonth;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}
	
	


	
}
