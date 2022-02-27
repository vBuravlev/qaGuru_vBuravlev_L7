package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step ("Открываем главную страницу")
    public MainPage openMainPage() {
        open("https://github.com");
        return this;
    }

    @Step("Ищем репозиторий {repository}")
    public MainPage searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
        return this;
    }

    @Step("Переходим в репозиторий")
    public MainPage followToRepository (String repository) {
        $("href*='/"+repository+"'").click();
        return this;
    }

    @Step("Проверяем что открылась страница репозитория {repository}")
    public MainPage shouldSeeRepository(String repository) {
        $x("a[text()='"+repository+"']").shouldBe(visible);
        return this;
    }

}
