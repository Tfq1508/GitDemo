package CrocusRobotic.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CrocusRobotic.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory!
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	////div[@id='toast-container']
	
	@FindBy(id="toast-container")
	WebElement errorMessage;
	
	//Actions Class
	
	public ProductCataloge loginApplication(String email, String passwrd)
	{	
		username.sendKeys(email);
		password.sendKeys(passwrd);
		submit.click();
		ProductCataloge productcat = new ProductCataloge(driver);
		return productcat;
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
