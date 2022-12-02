import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumWebSignupTest {

    //import the selenium WebDriver
    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // Open your Chrome browser
        driver = new ChromeDriver();

        // Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");

        // Wait for full loading
        Thread.sleep(2000);

        // Maximize the browser
        driver.manage().window().maximize();

        //Test 1. Verify the user input the correct url & is on the right webpage.
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            System.out.println("User is on the Correct Webpage");
        else
            System.out.println("User is on the Wrong Webpage");
        Thread.sleep(4000);

    }
    @Test (priority = 0)
    public void signupPage() throws InterruptedException {
        //click on Signup button to open signup page
        //Verify the Signup button functionality
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            System.out.println("Correct Signup page");
        else
            System.out.println("Wrong Signup page");
        Thread.sleep(4000);
    }

    @Test (priority = 1)
    public void positiveSignup() throws InterruptedException {
        //Verify that user is successfully signed up when valid details are inputted.
        // Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys(new String[]{"shegz2490"});

        // Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys(new String[]{"shegz2410@mailinator.com"});

        // Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys(new String[]{"Passwordis@1"});

        // Click on the signup button
        driver.findElement(By.id("submit")).click();

        String expectedPageTitle = "AlphaBlog";
        String actualPageTitle = driver.getTitle();
        if(actualPageTitle.contains(expectedPageTitle))
            System.out.println("Signup Successful");
        else
            System.out.println("Signup Unsuccessful");
        Thread.sleep(4000);
    }

    @Test (priority = 2)
    public void userItem() throws InterruptedException {
        // Click on User1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();

        // Verify that user clicks on the signup button, the user is directed to the signUp page.
        String expectedUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualUrl = driver.getCurrentUrl();
            if (actualUrl.contains(expectedUrl))
                System.out.println("Correct User1");
            else
                System.out.println("Wrong User1");
        Thread.sleep(4000);
    }

    @Test (priority = 3)
    public void verifyItem() throws InterruptedException {
        // Verify that the item searched for on the User1 page is present.
        // Search for an item (Using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[35]/div/div/div[1]/a")).click();
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/articles/48";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            System.out.println("Correct item page");
        else
            System.out.println("Wrong item 1page");
        Thread.sleep(4000);
    }


    @Test (priority = 4)
    public void logoutSuccessfully() throws InterruptedException {
        // Click on logout
        // Verify that when the user logout, he/she is directed back to the home page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Logout Successful");
        else
            System.out.println("Logout Unsuccessful");
        Thread.sleep(4000);
    }

    @Test (priority = 5)
    public void negativeSignup() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(4000);

        // Verify that user cannot sign up with username less than 3 characters.
        // Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys(new String[]{"se"});

        // Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys(new String[]{"shegz00@mailinator.com"});

        // Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys(new String[]{"Passwordis@1"});

        // Click on the signup button
        driver.findElement(By.id("submit")).click();
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users"))
            System.out.println("User was not signed up successfully");
        else
            System.out.println("User signed up successfully");
        Thread.sleep(4000);
    }

    @Test (priority = 6)
    public void invalidLogin() throws InterruptedException {
        //Click on logIn button to open the logIn page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        Thread.sleep(4000);
        // Verify user cannot log in with password less than or equal to one character.
        // Input your username on the username field
        //driver.findElement(By.id("user_username")).sendKeys(new String[]{"shegz979"});

        // Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("session_email")).sendKeys(new String[]{"shegz99@mailinator.com"});

        // Locate the password field and Input your password on the username field
        driver.findElement(By.id("session_password")).sendKeys(new String[]{"P"});

        // Click on the Login button
        driver.findElement(By.name("commit")).click();

        String expectedUrl = "https://selenium-blog.herokuapp.com/login";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Unable to login");
        else
            System.out.println("Login successfully");
        Thread.sleep(4000);
    }

    @Test (priority = 7)
    public void blankSignup() throws InterruptedException {
        //Click on logIn button to open the logIn page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(4000);
        // Verify user cannot sign up with either/all the fields blank.
        // Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys(new String[]{""});

        // Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys(new String[]{""});

        // Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys(new String[]{""});

        // Click on the Login button
        driver.findElement(By.id("submit")).click();

        String expectedUrl = "https://selenium-blog.herokuapp.com/users.";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Signup successfully");
        else
            System.out.println("Unable to signup");
        Thread.sleep(4000);
    }
    @Test (priority = 8)
    public void invalidEmailSignup() throws InterruptedException {
        //Click on signUp button to open the signUp page
        //driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        //Thread.sleep(5000);

        // Verify user cannot sign up with invalid email address.
        // Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys(new String[]{"Selebobo1"});

        // Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys(new String[]{"!w@t.co"});

        // Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys(new String[]{"Password@1"});

        // Click on the Login button
        driver.findElement(By.id("submit")).click();

        String expectedUrl = "https://selenium-blog.herokuapp.com/users.";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Signup successfully");
        else
            System.out.println("Unable to signup");
        Thread.sleep(4000);
    }

    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }
}

