package allureTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.IssuesPage;
import pages.MainPage;
import pages.RepositoryPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Feature("Задачи в репозитории")
public class AllureStepTest extends TestBase {

    @Test
    @Owner("buravlev_v_o")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Создание новой задачи")
    @DisplayName("Проверка создания Issue без авторизации пользователя")
    @Description(
            "Тест осуществляет проверку отображения Issue без авторизации пользователя"
    )
    @Link(value = "Testing", url = "https://github.com")
    void checkIssueNameTest() {
        Allure.parameter("REPOSITORY", TestBase.REPOSITORY);
        Allure.parameter("NAME_ISSUE", TestBase.NAME_ISSUE);

        new MainPage()
                .openMainPage()
                .searchForRepository(TestBase.REPOSITORY)
                .followToRepository(TestBase.REPOSITORY);

        new RepositoryPage()
                .shouldSeeRepository(TestBase.REPOSITORY)
                .openIssueTab();

        new IssuesPage()
                .shouldSeeNewIssue(TestBase.NAME_ISSUE);

        takeScreenshot();

    }


}
