package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class IssuesPage {

    @Step("Проверяем что открылась страница 'Issues'")
    public IssuesPage shouldSeeIssueWithNumber() {
        $("h3").$(withText("Welcome to issues!")).shouldBe(visible);
        return this;
    }
}
