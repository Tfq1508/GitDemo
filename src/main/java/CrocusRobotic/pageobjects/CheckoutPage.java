package CrocusRobotic.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import CrocusRobotic.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {	
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;

	@FindBy(css=".ta-results button:nth-of-type(2)")
	WebElement SelectCountry;


	@FindBy(xpath="//a[contains(@class, 'btnn action__submit')]")
	WebElement button;
	
	By lastwait= By.cssSelector(".ta-results button:nth-of-type(2)");
	
	
	public void selectCountry(String CountryName)
	{
		Actions a= new Actions(driver);
		a.sendKeys(Country, CountryName).build().perform();
		waitForElementTobeAppear(lastwait);
		SelectCountry.click();
	}
	
	public ConfirmationPage submitOrder()
	{
		button.click();
		return new ConfirmationPage(driver);
		
	}


}
