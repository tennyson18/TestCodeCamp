import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class JumiaWebLoginTest {
    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //Open Chrome browser
        driver = new ChromeDriver();

        //Input Jumia Page URL (https://www.jumia.com.ng/)
        driver.get("https://www.jumia.com.ng/");

        //Maximize the browser
        driver.manage().window().maximize();

    }

    @Test(priority = 0)
        public void pageUrl() throws InterruptedException {
        //Verify the user input the correct url.

        if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
            System.out.println("Correct Url");
        else
            System.out.println("Wrong Url");
        Thread.sleep(3000);
    }


    @Test(priority = 1)
    public void pageTitle() throws InterruptedException {
        //Verify user is on the right page.

        //Get the page title
        String expectedPageTitle = "Jumia Nigeria | Online Shopping for Groceries, Appliances & More!";
        String actualPageTitle = driver.getTitle();
        if (actualPageTitle.contains(expectedPageTitle))
            System.out.println("User is on the Correct Webpage");
        else
            System.out.println("User is on the Wrong Webpage");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void signInButton() throws InterruptedException {
        //Verify the signin button takes you to the signin page.

        //Click on the account button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();

        //Click on the sign-in button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();

        String expectedUrl = "https://my.jumia.com.ng/interaction/1ATBzB5hmINlCRHEE6iDs/en-ng/sign-in/email";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("User is not on the signin page");
        else
            System.out.println("User is on the signin page");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void validLogin() throws InterruptedException {

        //Input your email address
        driver.findElement(By.name("email")).sendKeys("Trey@mailinator.com");

        //Click on the continue button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        Thread.sleep(3000);

        //Input your password
        driver.findElement(By.name("password")).sendKeys("Passwordisadmin@1");

        //Click on the login
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
        Thread.sleep(3000);

        //Verify User is correctly logged in
        //Click on account name
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        //Click on my account
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/a[1]")).click();

        String expectedUrl = "https://www.jumia.com.ng/customer/account/index/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("User is properly logged in");
        else
            System.out.println("User is not properly logged in");
        Thread.sleep(3000);
    }

    @Test (priority = 3)
    public void pageLogout() throws InterruptedException {

        //Verify user is correctly logged out.
        //Click on account name //*[@id="dpdw-login-box"]/div/form/button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();

        //Logout from the account
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();

        String expectedUrl = "https://www.jumia.com.ng/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("User is properly logged out");
        else
            System.out.println("User is not properly logged out");
        Thread.sleep(3000);
    }

    @Test (priority = 4)
    public void wrongEmailLogin() throws InterruptedException {

        //Note: The way the website is designed, if a user logs in with an unrecognized email, it directs user to create an account.
        //Click on the account button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();

        //Click on the sign-in button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();

        //Input a wrong email address
        driver.findElement(By.name("email")).sendKeys("Treyy@mailinator.com");

        //Click on the continue button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        Thread.sleep(3000);


        //Verify User is can not log in with a wrong email
        //driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
        if (driver.getCurrentUrl().contains("https://my.jumia.com.ng/interaction/GDKCCwGuDzpPBtk6pENmt/en-ng/sign-in"))
            System.out.println("Passed");
        else
            System.out.println("Failed");
    }

    @Test (priority = 5)
    public void invalidEmailLogin() throws InterruptedException {
        //Verify User is can not log in with an invalid email
        //Go to previous page
        driver.navigate().back();

        //Clear text field
        driver.findElement(By.name("email")).clear();

        //Input email address
        driver.findElement(By.name("email")).sendKeys("!#ty.com");

        //Click on continue
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        Thread.sleep(3000);

        // This will capture error message
        //String actual_msg=driver.findElement(By.name("email")).getText();

        String expectedUrl = "https://www.jumia.com.ng/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Successful User login");
        else
            System.out.println("Failed User login");
        Thread.sleep(3000);
    }

    @Test (priority = 6)
    public void blankEmailLogin() throws InterruptedException {

        //Verify User is can not log in with a blank email field
        //Clear text field
        driver.findElement(By.name("email")).clear();

        //Input email address
        driver.findElement(By.name("email")).sendKeys(" ");

        //Click on continue
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        Thread.sleep(3000);

        String expectedUrl = "https://www.jumia.com.ng/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Successful User login");
        else
            System.out.println("Failed User login");
        Thread.sleep(3000);
    }

    @Test (priority = 7)
    public void wrongPasswordLogin() throws InterruptedException {

        //Verify User is can not log in with a wrong password

        //Input email address
        driver.findElement(By.name("email")).sendKeys("Trey@mailinator.com");

        //Click on continue
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        Thread.sleep(3000);

        //Input password
        driver.findElement(By.name("password")).sendKeys("Passwordis@1");

        //Click on the login
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
        Thread.sleep(3000);

        // This will capture error message
        String actual_msg=driver.findElement(By.name("password")).getText();

        String expectedUrl = "https://www.jumia.com.ng/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Successful User login");
        else
            System.out.println("Failed User login");
        Thread.sleep(3000);
    }

    @Test (priority = 8)
    public void blankPasswordLogin() throws InterruptedException {
        //Verify User is can not log in with a blank password field

        //Clear text field
        driver.findElement(By.name("password")).clear();

        //Input password
        driver.findElement(By.name("password")).sendKeys("");

        //Click on the login
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
        Thread.sleep(3000);

        // This will capture error message
        String actual_msg=driver.findElement(By.name("password")).getText();

        String expectedUrl = "https://www.jumia.com.ng/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Successful User login");
        else
            System.out.println("Failed User login");
        Thread.sleep(3000);
    }


    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }
}
