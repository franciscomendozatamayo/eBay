package com.eBayPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.CommonsMethods.CommonsMethods;

public class HomePage extends CommonsMethods {

	// link inicia sesion
	@FindBy(css = "#gh-ug > a:nth-child(1)")
	WebElement link_iniciaSesion;

	// Name User
	@FindBy(css = "#gh-ug > b:nth-child(1)")
	WebElement lbl_Username;

	// Input Buscar
	@FindBy(css = "#gh-ac")
	WebElement input_Buscar;
	// Btn Buscar
	@FindBy(css = "#gh-btn")
	WebElement btn_Buscar;

	// Result Item Search
	@FindBy(css = "li.s-item > div > div > a")
	List<WebElement> resultItemsSearch;

	// Btn Agregar al carro de compras
	@FindBy(xpath =  "//*[@id=\"isCartBtn_btn\"]")
	WebElement btn_AgregarCarroCompras;

	// Btn Shopping Cart
	@FindBy(css = ".gh-cart-count-1")
	WebElement btn_CarroCompras;

	public void linkIniciaSesion() {

		clickElement(link_iniciaSesion);

	}// end linkIniciaSesion

	public String lblNameUsername() {

		String getTextlbl = getTextElement(lbl_Username);

		return getTextlbl;

	}// end lblNameUsername

	public void searchArticle(String txtArticle) {

		sendKeysElement(input_Buscar, txtArticle);
		clickElement(btn_Buscar);

	}// end searchArticle

	public Boolean clickArticleSearch(String txtArticle) {

		Boolean status = clickElementList(resultItemsSearch, txtArticle);

		return status;

	}// end clickArticleSearch

	public void addToShoppingCartArticle() {

		clickElement(btn_AgregarCarroCompras);

	}// end addToShoppingCartArticle

	public void shoppingCart() {

		clickElement(btn_CarroCompras);

	}// end addToShoppingCartArticle

}// end LoginPage
