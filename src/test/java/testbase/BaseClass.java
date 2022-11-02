package testbase;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	@BeforeClass
	@Parameters({"browser"})

	public void setup() {
		rb = ResourceBundle.getBundle("config");
		logger = LogManager.getLogger(this.getClass());
	   WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger.info("Launched Chrome Browser");
	}
	/* if (br.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger.info("launched Chrome browser");
	} else if (br.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		logger.info("Launched EDge browser");
	} else if (br.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		logger.info("Launched Firefox browser");
	}}*/
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

	public String ramdomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return (generatedstring);
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
	}
}
