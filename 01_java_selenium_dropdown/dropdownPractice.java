import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\RAFARS\\drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Scanner scanner = new Scanner(System.in);
		driver.get("https://www.pagibigfundservices.com/OnlinePublicAuction");
		String regionID, provinceID, municipalityID;
		String regionText, provinceText, municipalityText;
		regionID="region";
		provinceID="province";
		municipalityID="city";
		regionText="REGION 4-A (CALABARZON)";
		provinceText="cavite";
		municipalityText="imus";
		
	selector(driver, regionID, regionText);		//select region
	selector(driver, provinceID, provinceText);	//select province
	selector(driver, municipalityID, municipalityText);	//select city
	driver.findElement(By.id("search-button")).click(); //click search
	
	}
	
	public static void selector(WebDriver driver, String idText, String selectWhat) {


		WebElement selectElement = driver.findElement(By.id(idText));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectElement);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectElement.click();
		Select select = new Select(selectElement);
		List<WebElement> options =select.getOptions();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (WebElement option:options) {
			if (option.getText().toLowerCase().contains(selectWhat.toLowerCase())){
				System.out.println(option.getText());
				option.click();
				break;
			}
		}
		driver.findElement(By.tagName("body")).click(); // Clicks outside to close the select dropdown

	}
	

}
