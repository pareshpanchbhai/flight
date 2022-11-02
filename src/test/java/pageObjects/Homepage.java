package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepage {
	WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Register")
	WebElement lnkReg;

	@FindBy(id = "name")
	WebElement txtfirstname;

	@FindBy(id = "contact")
	WebElement txtCon_no;

	@FindBy(id = "email")
	WebElement txtemail;

	@FindBy(id = "address")
	WebElement txtpassword;

	@FindBy(name = "gender")
	WebElement dpgender;

	@FindBy(name = "dob")
	WebElement txtdate;
  
	@FindBy(id ="flexCheckChecked")
	WebElement chkdconfirm;
	
	@FindBy(name = "submit") 
	WebElement rdReg;
	
	public void clickRegister() {
		lnkReg.click();
	}

	public void setFirstname(String fname) {
		txtfirstname.sendKeys(fname);
	}

	public void setcontact(String contact) {
		txtCon_no.sendKeys(contact);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}

	public void setgender() {
		Select gen = new Select(dpgender);
		gen.selectByVisibleText("Male");
	}

	public void setDob(String dob) {
		txtdate.sendKeys(dob);
	}
    public void clickcheckbox()
    {
    	chkdconfirm.click();
    }
    public void clickReg()
    {
    	rdReg.click();
    }
}
