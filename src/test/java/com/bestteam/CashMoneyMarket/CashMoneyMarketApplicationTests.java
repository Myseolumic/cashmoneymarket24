package com.bestteam.CashMoneyMarket;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CashMoneyMarketApplicationTests {

    private final String URL = "https://cashmoneymarket.herokuapp.com/";
    private WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void clickLoginButton() {
        driver.findElement(By.linkText("Login")).click();
        assertEquals(URL + "login", driver.getCurrentUrl());
    }
}
