package TestVase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static WebDriver wait;

	public TestBase() throws Exception {
		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"D:\\SeleniumQspiders\\com.nopCommerce.qa\\src\\main\\java\\com\\demo\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization() {
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);

//		System.setProperty("webdriver.chrome.driver", "D:\\GLAMS\\chromedriver-win64\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}
