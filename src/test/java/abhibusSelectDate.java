import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class abhibusSelectDate {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.abhibus.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("Mysore");
		driver.findElement(By.xpath("//input[@placeholder='Onward Journey Date']")).click();
		driver.findElement(By.xpath("//span[@class='calender-month-change']")).click();

	}

}
