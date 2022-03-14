package com.eBayPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.CommonsMethods.CommonsMethods;

public class LoginPage extends CommonsMethods {

	// Input Email - User
	@FindBy(css = "#userid")
	WebElement input_EmailUser;
	// Btn Continuar
	@FindBy(css = "#signin-continue-btn")
	WebElement btn_Continuar;
	// Input Password
	@FindBy(css = "#pass")
	WebElement input_Password;
	// Btn Iniciar Sesion
	@FindBy(css = "#sgnBt")
	WebElement btn_IniciarSesion;

	public void captureUserOrEmail(String UserMail) {

		sendKeysElement(input_EmailUser, UserMail);
		clickElement(btn_Continuar);

	}// end captureUserOrEmail

	public void capturePassword(String Password) {

		sendKeysElement(input_Password, Password);
		clickElement(btn_IniciarSesion);

	}// end captureUserOrEmail

}// end LoginPage
