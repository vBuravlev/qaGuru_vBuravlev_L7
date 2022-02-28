package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
        open(baseUrl);
        return this;
    }

    @Step("Ищем репозиторий {repository}")
    public MainPage searchForRepository(String repository) {
        $(".header-search-input").setValue(repository).submit();
        return this;
    }

    @Step("Переходим в репозиторий")
    public MainPage followToRepository(String repository) {
        $x("//*[@href='/"+repository+"']").click();
        return this;
    }


}
