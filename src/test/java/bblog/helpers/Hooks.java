package bblog.helpers;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.BeforeClass;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
		    embedScreenshotIntoReport(scenario);
		}
		if (driver != null) {
			driver.quit();
		}
	}

	private void embedScreenshotIntoReport(Scenario scenario) {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName() + "(" + scenario.getUri()+")");
	}
}
