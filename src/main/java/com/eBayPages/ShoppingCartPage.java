package com.eBayPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.CommonsMethods.CommonsMethods;

public class ShoppingCartPage extends CommonsMethods{
	
	
	//Lbl Name Article
	@FindBy(css = ".BOLD")
	WebElement lbl_NameArticle;
	
	
	public String lblNameArticle() {

		String getTextlbl = getTextElement(lbl_NameArticle);

		return getTextlbl;

	}// end lblNameUsername
	
	

}//end ShoppingCartPage
