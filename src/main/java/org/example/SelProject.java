package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.awt.*;

public class SelProject {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.edge.driver", "selenium\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.rw.by/?ysclid=lll9kn5qh7855351791");

        WebElement fromCountry = driver.findElement(By.xpath("//*[@id=\"acFrom\"]"));
        WebElement toCountry = driver.findElement(By.xpath("//*[@id=\"acTo\"]"));
        WebElement date = driver.findElement(By.xpath("//*[@id=\"yDate\"]"));
        WebElement find = driver.findElement(By.xpath("//*[@id=\"fTickets\"]/div[2]/div[1]/span/input"));

        fromCountry.sendKeys("Витебск");

        Thread.sleep(3000);

        toCountry.sendKeys("Минск");

        //Thread.sleep(20000);

        date.sendKeys("29.08.2023");
        find.click();

        TrayIconDemo demo = new TrayIconDemo();
        demo.displayTray("hello, mikee");
        // driver.quit();

    }
}
