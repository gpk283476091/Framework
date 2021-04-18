package org.locators;

import org.base.BaaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdacitinSelectHotel extends BaaseClass{
	
	public AdacitinSelectHotel()  {
PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement radiobutton;
	
	@FindBy(id="continue")
	private WebElement continuebtn;

	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public WebElement getContinuebtn() {
		return continuebtn;
	}
	
	public void radio() {
btnClick(getRadiobutton());
	}
	
	public void continueButton() {
btnClick(getContinuebtn());
	}

}
