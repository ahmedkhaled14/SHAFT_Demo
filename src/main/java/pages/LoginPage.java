package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {
    private String url = "https://www.automationexercise.com/login";

    private final By signup_name = By.name("name");
    private final By signup_email = By.xpath("//input[@data-qa='signup-email']");
    private final By signup_button = By.xpath("//button[@data-qa='signup-button']");
    private final By newUserSignupText = By.xpath("//div[@class='signup-form']/h2");

    SHAFT.GUI.WebDriver driver;

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.browser().navigateToURL(url);
    }


    public void newUserSignup(String signupUserName, String signupEmail) {
        driver.element().type(signup_name,signupUserName);
        driver.element().type(signup_email,signupEmail);
        driver.element().click(signup_button);
    }

    public void assertOnNewUserSignupText(String expected) {
 driver.element().assertThat(newUserSignupText).text().isEqualTo(expected).perform();
    }


}
