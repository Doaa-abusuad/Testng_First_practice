import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestngPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");

		String UserName = "standard_user";
		String Password = "secret_sauce";

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(UserName);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Password);

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		Thread.sleep(1000);
		List<WebElement> Items = driver.findElements(By.className("btn_primary"));
		System.out.println(Items.size());

		for (int i = 0; i < Items.size(); i++) {
			Items.get(i).click();
		}

		int ActualNo = Items.size();
		String expectedValue = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		int expectNo = Integer.parseInt(expectedValue);
		System.out.println(expectNo);

		Assert.assertEquals(ActualNo, expectNo);

	}

}
