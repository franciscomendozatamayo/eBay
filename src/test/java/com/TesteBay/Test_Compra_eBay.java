package com.TesteBay;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.CommonsMethods.CommonsMethods;
import com.eBayPages.HomePage;
import com.eBayPages.LoginPage;
import com.eBayPages.ShoppingCartPage;

public class Test_Compra_eBay extends CommonsMethods{
	
	WebDriver driver;
	
	@Parameters({ "browser", "url" })
	@BeforeTest
	public void start(String browser, String url) {

		driver = CommonsMethods.startBrowser(browser, url);
		driver.manage().window().maximize();

	}// end start
	
	@Test(priority = 1)
	public void TestLinkIniciaSesion_eBay() {
		
		Reporter.log("Link Inicia Sesion");
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.linkIniciaSesion();
		
	}//end TestLinkIniciaSesion_eBay
	
	@Parameters({"UserOrEmail","Password", "Username"})
	@Test(priority = 2)
	public void TestLoginApplication_eBay(String UserOrEmail, String Password, String Username) throws Exception {

		Reporter.log("Login");
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.captureUserOrEmail(UserOrEmail);
		lp.capturePassword(Password);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		String lblUsernameActual = hp.lblNameUsername();
		Assert.assertEquals(lblUsernameActual, Username);
		
	}// end TestLoginApplication_eBay
	
	@Parameters({"Article", "SearchArticle"})
	@Test(priority = 3)
	public void TestSearchAddShoppingCartArticle_eBay(String Article, String SearchArticle) throws Exception {

		Reporter.log("Buscar Articulo");
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.searchArticle(Article);
		Boolean status = hp.clickArticleSearch(SearchArticle);
		Assert.assertTrue(status);
		hp.addToShoppingCartArticle();
		
	}// end TestSearchAddShoppingCartArticle_eBay
	
	
	@Parameters({"SearchArticle"})
	@Test(priority = 4)
	public void TestShoppingCartArticle_eBay(String SearchArticle) throws Exception {

		Reporter.log("Valir Articulo Carrito de Compras");
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		manageWindowHandles(1);
		hp.addToShoppingCartArticle();
		ShoppingCartPage scp = PageFactory.initElements(driver, ShoppingCartPage.class);
		String lblArticleActual = scp.lblNameArticle();
		Assert.assertEquals(lblArticleActual, SearchArticle);
		
	}// end TestShoppingCartArticle_eBay
	
	
	@AfterTest
	public void end() {
		
		driver.quit();
	}
	
	
	
	
	
}//end Test_CompraeBay
