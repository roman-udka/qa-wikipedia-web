package org.wikipedia.en.automation.web.test;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

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
