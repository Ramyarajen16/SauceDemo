//********************************************************************************************
//*                                                                                          *
//*   Project name: SwagLabs                                                         	     *
//*   Module : DropdownValidation							     *
//*   Description:Dropdown validation Price (High to Low)				     *
//*  
//********************************************************************************************
/*  

Test Steps
Step 1. Goto https://www.saucedemo.com/
Step 2. Enter Valid Username
Step 3. Enter valid Password
Step 4. Click login Button
Step 5. Click the dropdown
Step 6. Select Price (High To Low)
Step 7. Verify the Products are sorted High to Low price 
Step 8. Get the product details with highest value
*/

package tests;
import java.util.List;
import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownValidationHightoLow {

	public static WebDriver driver;
	public static String username="standard_user";
	public static String password="secret_sauce";
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebElement dropdownName=driver.findElement(By.className("product_sort_container"));
		Select dropDown=new Select(dropdownName);
		dropDown.selectByValue("hilo");
		List<WebElement> ProductName=driver.findElements(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name']"));
		List<WebElement> productPrice=driver.findElements(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_price']"));
		TreeMap<Double,String> azlist=new TreeMap<Double,String>();
		int totalSize = ProductName.size();
		System.out.println(totalSize);
		for (int i = 0; i < ProductName.size(); i++) {
		String NameofProduct = ProductName.get(i).getText();
		String Price = productPrice.get(i).getText();
		Double prodPrice=Double.parseDouble(Price.replaceAll("[^0-9+.]", ""));
		System.out.println(NameofProduct);
		System.out.println(prodPrice);
		azlist.put( prodPrice,NameofProduct);

		}
		System.out.println(azlist);

		Double HighestProductPrice = azlist.lastEntry().getKey();
		String HighestProductName = azlist.lastEntry().getValue();
		System.out.println("Highest value Product is :"+ HighestProductName +":"  +HighestProductPrice);

		}

		}