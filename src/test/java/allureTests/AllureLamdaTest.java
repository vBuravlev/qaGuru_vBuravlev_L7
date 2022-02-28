package allureTests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

public class AllureLamdaTest extends TestBase {

    @Test
    void checkIssueNameTest()  {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open(baseUrl);
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий", () -> {
            $x("//*[@href='/" + REPOSITORY + "']").click();
        });

        step("Проверяем что открылась страница репозитория " + REPOSITORY, () -> {
            $x("//a[@href='/" + REPOSITORY + "']").shouldBe(visible);
        });

        step("Переходим в таб Issue", () -> {
            $(By.partialLinkText("Issues")).click();
        });

        step("Проверяем что существует Issue под названием " + NAME_ISSUE, () -> {
            $x("//div[@aria-label='Issues']//a[text()='" + NAME_ISSUE + "']").shouldBe(visible);
            addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
        });

    }
}
