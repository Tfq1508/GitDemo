package CrocusRobotic.test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CrocusRobotic.TestComponents.BaseTest;
import CrocusRobotic.pageobjects.CartPage;
import CrocusRobotic.pageobjects.CheckoutPage;
import CrocusRobotic.pageobjects.ConfirmationPage;
import CrocusRobotic.pageobjects.LandingPage;
import CrocusRobotic.pageobjects.ProductCataloge;

public class PlaceOrder extends BaseTest {

	@Test(dataProvider="getData", groups={"PurchaseOrder"})
public void submitOrder(String email, String paswrd, String ProductName) throws IOException {
		//String productName= "IPHONE 13 PRO";
		LandingPage landpage = launchApplication();
		ProductCataloge productcat=landpage.loginApplication(email, paswrd);
		List<WebElement> productNames=productcat.getProductList();
		productcat.addProductToCart(ProductName);
		CartPage cpage=productcat.goToCart();
		Boolean match=cpage.checkingItemsAddedInCart(ProductName);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage=cpage.clickonCheckout();
		checkoutpage.selectCountry("India");
		ConfirmationPage conpage= checkoutpage.submitOrder();
		String message=conpage.getConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		

	}

@DataProvider(name="getData")
public Object[][] getData()
{
return new Object[][] {{"Tfq@gmail.com", "Abc@#123","IPHONE 13 PRO" }, {"wahid@gmail.com", "XYz@#$1234", "ADIDAS ORIGINAL"}};
}


//	HashMap<String, String>map= new HashMap<String, String>();
//	
//	map.put("email", "Tfq@gmail.com");
//	map.put("Paswrd", "Abc@#123");
//	map.put("ProductName", "IPHONE 13 PRO");
//	
//	HashMap<String, String>map1= new HashMap<String, String>();
//	map1.put("email", "wahid@gmail.com");
//	map1.put("Paswrd", "XYz@#$1234");
//	map1.put("ProductName", "ADIDAS ORIGINAL");
//	}

//	@DataProvider
//	public Object[][] getData() throws IOException
//	{	
//		List<HashMap<String, String>> data = getJasonDataToMap(System.getProperty("used.dir")+ "src//test//java//CrocusRobotic//data//PurchaseOrder.jason");
//		return new Object[][] {{data.get(0)}, {data.get(1)}};
//	}
}
