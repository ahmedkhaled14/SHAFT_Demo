package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class DeleteAccountPage {
    private String url = "https://www.automationexercise.com/delete_account";
    private final By accountDeleted = By.xpath("//h2[@class='title text-center']");
    private final By continue_button = By.xpath("//a[@data-qa='continue-button']");

    SHAFT.GUI.WebDriver driver;

    public DeleteAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnContinueButton() {
        driver.element().click(continue_button);
    }
    public void navigate(){
        driver.browser().navigateToURL(url);
    }

    public void assertOnAccountDeletedTextMessage(String expected) {
        driver.element().assertThat(accountDeleted).text().isEqualTo(expected).perform();
    }

}
