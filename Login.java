//********************************************************************************************
//*                                                                                          *
//*   Project name: SwagLabs                                                      			 
//*   Module : Login                                                                         *
//*   Description: Verify the Login functionality with valid data                            *                                                                                      *

//********************************************************************************************
/*  

Test Steps
Step 1. Goto https://www.saucedemo.com/
Step 2. Enter Valid Username 
Step 3. Enter valid Password
Step 4. Click login Button
*/
package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static WebDriver driver;
	public static String username="standard_user";
	public static String password="secret_sauce";
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.close();
}

}
