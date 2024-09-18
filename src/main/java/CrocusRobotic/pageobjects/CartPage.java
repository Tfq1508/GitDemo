package CrocusRobotic.pageobjects;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CrocusRobotic.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {	
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;

	//driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement checkoutbutton;

	public Boolean checkingItemsAddedInCart(String productName)
	{
		Boolean match=cartItems.stream().anyMatch(s-> s.getText().equalsIgnoreCase(productName));
		return match;
	}

	public CheckoutPage clickonCheckout()
	{
		checkoutbutton.click();
		return new CheckoutPage(driver);

	}
}
