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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	//private Logger logger;


	/*
	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
		//logger = LoggerFactory.getLogger();
	}

	 */

	@Before
	public void beforeScenario(Scenario scenario) {
		//Logger.getAnonymousLogger().log(Level.INFO, "Starting first step of scenario '"+scenario.getName()+"'...");
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
		//Logger.getAnonymousLogger().log(Level.INFO, "Last step of scenario '"+scenario.getName()+"' finished");
	}

	private void embedScreenshotIntoReport(Scenario scenario) {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName() + "(" + scenario.getUri()+")");
	}
}
