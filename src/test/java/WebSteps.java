import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step ("Открываем главную страницу")
    public WebSteps openMainPage() {
        open("https://github.com");
        return this;
    }



    @Step("Открываем репозиторий {repository}")
    public WebSteps openRepository(String repository) {
        $(By.linkText(repository)).click();
        return this;
    }

    @Step("Переходим в таб 'Issue'")
    public WebSteps openIssueTab() {
        $(By.partialLinkText("Issues")).click();
        return this;
    }

    @Step("Проверяем что совершен успешный переход на страницу 'Issue'")
    public WebSteps shouldSeeIssue () {
        $(withText("Welcome to issues!")).should(Condition.exist);
        return this;
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
