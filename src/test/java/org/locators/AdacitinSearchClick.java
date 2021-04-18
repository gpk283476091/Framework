package org.locators;

import org.base.BaaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdacitinSearchClick extends BaaseClass{

	public AdacitinSearchClick() {
PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	@FindBy(id="Submit")
	private WebElement submitbutton;
	
	
	
	public void btn() {
		btnClick(getSubmitbutton());
	}

	
		
	
	
	
	
	
	
	
}
