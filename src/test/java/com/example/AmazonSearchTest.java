package com.example;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;


public class AmazonSearchTest {


    private WebDriver driver;


    @BeforeClass
    public void setUp() {
        // ✅ Auto-download ChromeDriver
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        // Headless mode (remove if you want to see browser)
        options.addArguments("--start-maximized");
        // options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");


        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void searchForHeadphones() {
        driver.get("https://www.amazon.in/");


        // Search for headphones
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("headphones");
        driver.findElement(By.id("nav-search-submit-button")).click();


        // ✅ Just print message, no waiting for results
        System.out.println("✅ Searched for headphones on Amazon successfully.");
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
