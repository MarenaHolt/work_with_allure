package allure_hw;

import allure_lec.WebSteps;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueStepsTests {

    public static final int ISSUE = 68;
    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final String ISSUENAME = "Listeners NamedBy";

    @Test
    public void testWithStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsForTest steps = new StepsForTest();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE, ISSUENAME);

    }
}
