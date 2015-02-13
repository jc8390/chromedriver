import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium2Example {
	public static void main(String[] args) throws MalformedURLException {
          
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("androidPackage", "com.android.chrome");
     
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), capabilities);
        
        driver.get("http://cert.gogetwaggle.com/Login/#/login/SchoolAutomation");

        driver.findElements(By.className("input-box")).get(0).sendKeys("sadmin13");
        driver.findElements(By.className("input-box")).get(1).sendKeys("uA$1Szjp");
        driver.findElement(By.className("login-button")).click();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        driver.quit();
    }
}
