package bblog.pageobjects;

import bblog.WebDriverWrapper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
	private WebDriver driver;

	private String HOME_URL = "https://candidatex:qa-is-cool@qa-task.backbasecloud.com/#/";
	
	private By usernameBy = By.xpath("//input[@placeholder='Username']");
	private By passwordBy = By.xpath("//input[@placeholder='Password']");
	private By signInBy = By.xpath("//button[@type='submit' and contains(text(),\"Sign in\")]");

	public HomePage(WebDriverWrapper wrapper) {
		this.driver = wrapper.getDriver();
	}
	
	public HomePage navigateTo(String url) {
		driver.get(url);
		return this;
	}

	public HomePage navigateToHome(String url) {
		driver.get(HOME_URL + url);
		return this;
	}

	public void enterUserName() {
		driver.findElement(usernameBy).sendKeys("AdamSTester");
	}

	public void enterEmail() {
		driver.findElement(usernameBy).sendKeys("awschultz21@gmail.com");
	}

	public void enterPassword() {
		driver.findElement(passwordBy).sendKeys("@utoT3ster");
	}

	public void clickSignIn() {
		driver.findElement(signInBy).click();
	}

	public void verifyHomePage() {
		Assert.assertEquals(HOME_URL, driver.getCurrentUrl());
	}

}
