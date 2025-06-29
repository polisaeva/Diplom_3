package ru.practicum.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserManager {

    public static WebDriver createBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "yandex":
                return setupYandex();
            case "chrome":
            default:
                return setupChrome();
        }
    }

    //Метод настройки Google Chrome
    private static WebDriver setupChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// Автозагрузка драйвера
        return driver;
    }

    // Метод для настройки Яндекс.Браузера
    private static WebDriver setupYandex() {
        //Путь до файла браузера и драйвера к нему
        String yandexBrowserPath = "C:\\Users\\Polina\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\yandexdriver-25.6.0.2261-win64\\yandexdriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary(yandexBrowserPath);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}