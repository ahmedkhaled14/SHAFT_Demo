import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class TestConfigurations {
    SHAFT.GUI.WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    MenuPage menuPage;
    DeleteAccountPage deleteAccountPage;

    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        homePage.navigate();
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        menuPage = new MenuPage(driver);
        deleteAccountPage = new DeleteAccountPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
