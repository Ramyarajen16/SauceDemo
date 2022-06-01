//********************************************************************************************
//*                                                                                          *
//*   Project name: SwagLabs                                                                 *
//*   Module : Add to cart functionality                                                     *
//*   Description:  Verifying Add to cart functionality                                      *                     

//********************************************************************************************
/*  

Test Steps
Step 1. Goto https://www.saucedemo.com/
Step 2. Enter Valid Username
Step 3. Enter valid Password
Step 4. Click login Button
Step 5. Add the Sauce Labs Backpack in the cart
Step 6: Click the cart icon in the right top corner
Step 7: Click Checkout button
Step 8: Enter User Information
Step 9: Click Continue button
Step 10: Click Finish button
Step 11: Verify the Message on the page
 */
package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddtoCart {

	public static WebDriver driver;
	public static String username="standard_user";
	public static String password="secret_sauce";
	public static String first_name="Ramya";
	public static String last_name="Rajendran";
	public static String zip_code="L5B0G9";
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("first_name");
		driver.findElement(By.id("last-name")).sendKeys(last_name);
		driver.findElement(By.id("postal-code")).sendKeys(zip_code);
		driver.findElement(By.id("continue")).click();
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		driver.findElement(By.id("finish")).click();
		String expected_message="THANK YOU FOR YOUR ORDER";
		String actual_message = driver.findElement(By.xpath("//*[@id='checkout_complete_container']//h2")).getText().trim();
		if(expected_message.equals(actual_message)) {
			System.out.println(expected_message);
		}
		else {
			System.out.println("Please verify the details");
		}

		Thread.sleep(4000);
		driver.close();

	}

}