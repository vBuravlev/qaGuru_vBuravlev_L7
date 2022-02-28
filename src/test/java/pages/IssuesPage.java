package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class IssuesPage {

    @Step("Проверяем что существует Issue под названием {nameIssue}")
    public IssuesPage shouldSeeNewIssue(String nameIssue) {
        $x("//div[@aria-label='Issues']//a[text()='" + nameIssue + "']").shouldBe(visible);
        return this;
    }

}
