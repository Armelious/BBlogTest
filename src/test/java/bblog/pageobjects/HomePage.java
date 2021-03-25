package bblog.pageobjects;

import bblog.helpers.WebDriverHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
	private WebDriverHelper driverHelper;
	private WebDriver driver;

	private String HOME_URL = "https://candidatex:qa-is-cool@qa-task.backbasecloud.com/#/";
	// todo keep these in an encrypted property file
	private String USERNAME = "adamstester";
	private String EMAIL = "awschultz21@gmail.com";
	private String PASS = "@utoT3ster"; //not my real password

	private By usernameBy = By.xpath("//input[@placeholder='Username']");
	private By passwordBy = By.xpath("//input[@placeholder='Password']");
	private By signInBy = By.xpath("//button[@type='submit' and contains(text(),\"Sign in\")]");


	public HomePage(WebDriverHelper driverHelper) {
		this.driverHelper = driverHelper;
		this.driver = driverHelper.getDriver();
	}

	/**
	 * navigate the browser to an exact url
	 * @param url String the exact url string
	 */
	public void navigateTo(String url) {
		driver.get(url);
	}

	/**
	 * navigate the browser to a {@link #HOME_URL} + with following url string
	 * @param url String text following the home url
	 */
	public void navigateToHome(String url) {
		driver.get(HOME_URL + url);
	}

	public void enterUserName() {
		driver.findElement(usernameBy).sendKeys(USERNAME);
	}

	public void enterEmail() {
		driver.findElement(usernameBy).sendKeys(EMAIL);
	}

	public void enterPassword() {
		driver.findElement(passwordBy).sendKeys(PASS);
	}

	/**
	 * Click the Sign in Button and wait for the page to load
	 */
	public void clickSignIn() {
		driverHelper.clickElementAndWait(signInBy);
	}

	/**
	 * Click the profile username nav link.
	 * Don't need to wait for page to load as only the content changes.
	 */
	public void clickUserName() {
		By linkBy = By.xpath("//a[contains(text(),\""+ USERNAME + "\")]");
		driverHelper.clickElement(linkBy);
	}

	/**
	 * Verify the current page matches the {@link #HOME_URL}
	 */
	public void verifyHomePage() {
		Assert.assertEquals(HOME_URL, driver.getCurrentUrl());
	}

	/**
	 * Click a link by it's text
	 * Don't wait for page to load.
	 * @param linkText String exact link text to click
	 */
	public void clickElement(String linkText) {
		By webElementBy = By.linkText(linkText);
		driverHelper.clickElement(webElementBy);
	}

	/**
	 * Click a link by it's text and wait for the page to load
	 * @param linkText String exact link text to click
	 */
	public void clickLinkText(String linkText) {
		By linkBy = By.linkText(linkText);
		driverHelper.clickElementAndWait(linkBy);
	}

	/**
	 * Click an articles header text.
	 * Determine the article by the number in the app-article-list.
	 * Wait for the page to load
	 * @param article integer of the article number
	 */
	public void clickNthArticleHeader(int article) {
		By linkBy = By.xpath("//app-article-list-item[" + article + "]//h1");
		driverHelper.clickElementAndWait(linkBy);
	}



}
