package org.wikipedia.en.automation.web.test;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

     /**
     * I use this because @parameters method is executed before @beforeclass method.
     * https://stackoverflow.com/questions/11430859/parameters-method-is-executed-before-beforeclass-method
     */
    static {
        setUp();
    }

    public static void setUp() {
        setUpBrowser();
    }

    private static void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        WebDriverRunner.setWebDriver(new ChromeDriver());
    }

    @AfterClass
    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
