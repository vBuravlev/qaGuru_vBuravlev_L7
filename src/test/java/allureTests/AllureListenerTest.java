package allureTests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.addAttachment;

public class AllureListenerTest extends TestBase {

    @Test
    void checkIssueNameTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        //"Открываем главную страницу"
        open(baseUrl);

        //"Ищем репозиторий"
        $(".header-search-input").setValue(REPOSITORY).submit();

        //"Переходим в репозиторий"
        $x("//*[@href='/" + REPOSITORY + "']").click();


        //"Проверяем что открылась страница репозитория "
        $x("//a[@href='/" + REPOSITORY + "']").shouldBe(visible);

        //"Переходим в таб Issue"
        $(By.partialLinkText("Issues")).click();

        //"Проверяем что существует Issue под названием "
        $x("//div[@aria-label='Issues']//a[text()='" + NAME_ISSUE + "']").shouldBe(visible);
        addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
    }
}
