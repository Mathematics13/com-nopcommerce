package homework_week10;

/** Project-1 - ProjectName : com-nopcommerce
 BaseUrl = https://demo.nopcommerce.com/
 1. Setup chrome browser.
 2. Open URL.
 3. Print the title of the page.
 4. Print the current url.
 5. Print the page source.
 6. Navigate to Url.
 “https://demo.nopcommerce.com/login?returnUrl=
 %2F”
 7. Print the current url.
 8. Navigate back to the home page.
 9. Navigate to the login page.
 10. Print the current url.
 11. Refresh the page.
 12. Enter the email to email field.
 13. Enter the password to password field.
 14. Click on Login Button.
 15. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class AutomateNopCommerce
{
   static String baseUrl = "https://demo.nopcommerce.com/";
   static WebDriver driver;                                                     //declared as Global and initialized as local

    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
                                                                                 // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();                                            //browser launch

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));                       //implicitly wait of driver
        driver.manage().window().maximize();                                                    //maximize the window
        driver.get(baseUrl );                                                                  //get the base URL
        Thread.sleep(3000);

        String title = driver.getTitle();                                                     //get the title
        System.out.println("Title of the page :" +title );                                   //Printing the title of the page
        String currentUrl = driver.getCurrentUrl();                                         //get the current Url
        System.out.println(currentUrl);                                                    //Print the current url
        String pageSource = driver.getPageSource();
        System.out.println("Page Source is : " +pageSource );                            //Print the page source
        Thread.sleep(3000);

        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        String loginUrl = driver.getCurrentUrl();
        System.out.println(loginUrl);                                                    //navigate to Url
        Thread.sleep(3000);


        driver.navigate().back();                                                     //navigate back to the home page
        Thread.sleep(5000);
        driver.navigate().forward();                                                //navigate to the login page
        Thread.sleep(5000);

        String currentUrl1 = driver.getCurrentUrl();
        System.out.println(currentUrl1);
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(3000);

        WebElement email = driver.findElement(By.id("Email"));                   //Find,locate using id locator
        email.sendKeys("Prime123@gmail.com");                      //Action
        WebElement pwd = driver.findElement(By.name("Password"));             //Find,locate using name locator
        pwd.sendKeys("prime123");                               //Action
        WebElement link = driver.findElement(By.linkText("Log in"));       //Link login button
        link.click();                                                     //Action
        driver.quit();                                                  //Close all the browsers
    }
}

//        Multi Browser Testing
//        static String browser = "Chrome";                      //All static GV declared
//        if(browser.equalsIgnoreCase("Google Chrome"))
//        {
//            driver = new ChromeDriver();
//        }
//        else if(browser.equalsIgnoreCase("Mozilla Firefox"))
//        {
//            driver = new FirefoxDriver();
//        }
//        else if(browser.equalsIgnoreCase("Microsoft Edge"))
//        {
//            driver = new EdgeDriver();
//        }
//        else
//        {
//            System.out.println("Wrong Browser name");
//        }
