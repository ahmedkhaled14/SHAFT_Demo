package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class AccountCreatedPage {
    private String url = "https://www.automationexercise.com/account_created";
    private final By accountCreatedTextMessage = By.xpath("//h2[@class='title text-center']/b");
    private final By continue_button = By.xpath("//a[@data-qa='continue-button']");

    SHAFT.GUI.WebDriver driver;

    public AccountCreatedPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.browser().navigateToURL(url);
    }

    public void clickOnContinueButton() {
        driver.element().click(continue_button);
    }

    public void assertOnAccountCreatedTextMessage(String expected) {
        driver.element().assertThat(accountCreatedTextMessage).text().isEqualTo(expected).perform();
    }

}
