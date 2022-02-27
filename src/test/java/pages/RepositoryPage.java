package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class RepositoryPage {

    @Step("Переходим в таб Issue")
    public RepositoryPage openIssueTab() {
        $(By.partialLinkText("Issues")).click();
        return this;
    }

    @Step("Создаем новую Issue под названием {nameIssue}")
    public RepositoryPage createNewIssue (String nameIssue) {
        $x("span[text()='New issue']").click();
        $("input[placeholder='Title']").click();
        $("input[placeholder='Title']").sendKeys(nameIssue);
        $x("button[text()='IssueNew']").click();
        return this;
    }

    @Step("Проверяем что создалась Issue под названием {nameIssue}")
    public RepositoryPage shouldSeeNewIssue(String nameIssue) {
        $x("h1 span[text()='IssueNew']").shouldBe(visible);
        return this;
    }


}
