import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class shouldFindJUnit5 {
    @BeforeAll
    static void setUp () {
        Configuration.browserSize = "1920x1980";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
        //Configuration.holdBrowserOpen = true; конфигурация для проверки теста
    }

    @Test
    void findJUnit5() {

        //Открытие github
        open("/selenide/selenide");

        //Таб на Wiki
        $("#wiki-tab").click();

        //Проверка наличия текста Soft assertions
        $("#wiki-body").shouldHave(text("Soft assertions")).click();

        //Открытие страницы Soft assertions
       $(".markdown-body").$(byText("Soft assertions")).click();

       //Проверка наличия кода для JUnit5
        $("#wiki-body").shouldHave(text("3. Using JUnit5 extend test class:"));
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
