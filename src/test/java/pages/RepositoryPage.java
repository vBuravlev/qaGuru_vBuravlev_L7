package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class RepositoryPage {

    @Step("Проверяем что открылась страница репозитория {repository}")
    public RepositoryPage shouldSeeRepository(String repository) {
        $x("//a[@href='/"+repository+"']").shouldBe(visible);
        return this;
    }

    @Step("Переходим в таб Issue")
    public RepositoryPage openIssueTab() {
        $(By.partialLinkText("Issues")).click();
        return this;
    }


}
