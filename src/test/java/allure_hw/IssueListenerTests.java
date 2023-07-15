package allure_hw;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueListenerTests {

    public static final int ISSUE = 68;
    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final String ISSUENAME = "Listeners NamedBy";

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue(REPOSITORY).submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        System.out.println();
        $("#issue_" + ISSUE + "_link").shouldHave(text(ISSUENAME));
    }
}
