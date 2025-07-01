package ru.practicum.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

public class DriverHelper {

    public WebDriver initDriver() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/browser.properties"));
        String browserProperty = properties.getProperty("testBrowser");
        System.out.println("browserProperty = " + browserProperty);
        BrowserType browserType = BrowserType.valueOf(browserProperty);

        switch (browserType) {
            case CHROME:
                return new ChromeDriver();
            case YANDEX:
                String yandexBrowserPath = "C:\\Users\\Polina\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
                System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\yandexdriver-25.6.0.2261-win64\\yandexdriver.exe");

                ChromeOptions options = new ChromeOptions();
                options.setBinary(yandexBrowserPath);

                return new ChromeDriver(options);
            default:
                throw new RemoteException("Browser undefined");
        }
    }
}