package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import testbase.BaseClass;

public class TC_001_Flight extends BaseClass
{
	@Test
  public void testResg() throws InterruptedException, IOException
  {
	  driver.get(rb.getString("appURL"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  
	  Homepage hp = new Homepage(driver);
	  hp.clickRegister();
	  hp.setFirstname("paresh");
	  hp.setcontact("9373726810");
	  hp.setEmail("gokbh@gmail.com");
	  hp.setPassword("Qedge123!@#");
	  hp.setgender();
	  hp.setDob("06-09-1994");
	  hp.clickcheckbox();
	  hp.clickReg();;
	  String verify = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/h4")).getText();
		  if(verify.toLowerCase().contains("paresh"))
		  {    
			  logger.info("passed");
			  Assert.assertTrue(true);
		  }else
		  {			  
			  logger.info("failed");
			  captureScreen(driver, "testResg");
			  Assert.assertTrue(false);
		  }
	  
  }
	
	
}
