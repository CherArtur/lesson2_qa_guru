import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class searchSoftAssertions {
    /*
    - Откройте страницу Selenide в Github

 - Перейдите в раздел Wiki проекта

 - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions

 - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

     */

    @Test
    void successfulSearchTest(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize="1920x1080";

        //Открыть страницу GitHub
        open("https://github.com/");
        //Проверка отображения заголовка на главной (страница прогрузилась)
        $(".h0-mktg").shouldHave(text("Let’s build from here"));
        //Ввод в строку поиска Selenide
        $("[name=q]").setValue("Selenide").pressEnter();
        //Кликнуть на первый результат из списка
        $$("ul.repo-list li").first().$("a").click();
        //Проверка заголовка selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        //Переход в wiki
        $("#wiki-tab").click();
        //Раскрытие полного списка разделов
        $("[data-filterable-for=wiki-pages-filter]").$("button").click();
        //Переход в SoftAssertions
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();
        //Проверка примера кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));

    }
}
