package CrocusRobotic.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CrocusRobotic.AbstractComponents.AbstractComponents;

public class ProductCataloge extends AbstractComponents{
	
	WebDriver driver;

	public ProductCataloge(WebDriver driver) {	
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	//List <WebElement> productNames=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> productList;
	
	//driver.findElement(By.cssSelector(".toast-container")
	@FindBy(css=".toast-container")
	WebElement wait2;
	
	
	By productBy= By.cssSelector(".mb-3");
	By addtoCart= By.cssSelector(".card-body button:last-of-type");
	By wait= By.cssSelector(".toast-container");
	
	public List<WebElement> getProductList()
	{ 
		waitForElementTobeAppear(productBy);
		return productList;
	}
	
	public WebElement getProductByName(String productname)
	{
		WebElement product=getProductList().stream().filter(s-> s.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return product;
	}
	
	public void addProductToCart(String productname)
	{
		WebElement product = getProductByName(productname);
		product.findElement(addtoCart).click();
		waitForElementTobeAppear(wait);
		waitForElementTodisappear(wait2);
	}

	
	
	

}
