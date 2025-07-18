
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;


public class LoginPageTest {

   public WebDriver driver;
    LoginPage loginPage;

    String testEmail = "sabeer.qatech7702@gmail.com";
    String testPassword = "Sabeer777!";
    String newPassword = "Sano777!";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SABEER\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        loginPage = new LoginPage(driver);
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    @Test
    public void testUserFlow() {
        loginPage.clickSignIn();
        loginPage.clickCreateAccount();
        loginPage.fillSignUpForm("Mohamed", "Sabeer", testEmail, testPassword, testPassword);
        loginPage.submitRegistration();

        loginPage.openAccountSettings();
        loginPage.changePassword(testPassword, newPassword, newPassword);

        loginPage.logout();
        loginPage.clickSignIn();
        loginPage.login(testEmail, newPassword);

        loginPage.logout();
    }
}
