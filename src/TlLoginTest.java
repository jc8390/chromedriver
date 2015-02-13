import java.lang.reflect.Method;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TlLoginTest {

    private RemoteWebDriver driver;

    @Parameters({"username", "key"})
    @BeforeMethod
    public void setUp(@Optional("jc8390") String username,
                      @Optional("21a13290-d368-47bb-bc7f-ccf0384d6e76") String key,
                      Method method) throws Exception {
    	
    	DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("androidPackage", "com.android.chrome");
     
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    	
        
        // Create the connection to Sauce Labs to run the tests
       // this.driver = new RemoteWebDriver(
        //        new URL("http://" + username + ":" + key + "@ondemand.saucelabs.com:80/wd/hub"),
        //        capabilities);
        this.driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), capabilities);
    }

    @Test
    public void loginTest() throws Exception {
        // Make the browser get the page and check its title
    	driver.get("http://cert.gogetwaggle.com/Login/#/login/SchoolAutomation");
        
    	driver.findElements(By.className("input-box")).get(0).sendKeys("sadmin13");
        driver.findElements(By.className("input-box")).get(1).sendKeys("uA$1Szjp");
        
        driver.findElement(By.className("login-button")).click();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
    	
    }

   /* private void assertEquals(String string, String title) {
		// TODO Auto-generated method stub
		
	}*/

	@AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}
