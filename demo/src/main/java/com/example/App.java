package com.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.By;

public class App {
public static void main(String[] args){
// Mengantur Path / lokasi file yang ingin di eksekusi

    System.setProperty("webdriver.chrome.driver" , "D:\\Belajar Java\\Java\\Mvn.java\\browser\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    // ChromeOptions Options = new ChromeOptions();
    // WebDriver driver2   = new ChromeDriver(Options);
    driver.get("https://www.bukalapak.com/c/handphone/hp-smartphone?from=nav_header");
    driver.manage().window().maximize();

    DevTools devTools = ((ChromeDriver)driver).getDevTools();
    devTools.createSession();
    //jika ingin melakukan pengulangan secara unlimited
    // while (true) {
    //melakukan pengulangan sebanyak 3 kali
    for (int i=0; i<3; i++) {
// Mengambil via elements
    WebElement elemen = driver.findElement(By.cssSelector("#product-explorer-container > div > div.bl-flex-container > div.bl-flex-item.bl-product-list-wrapper > div > div:nth-child(2) > div:nth-child(3)"));
    String teks = elemen.getText();
    WebElement page = driver.findElement(By.cssSelector("body > div:nth-child(5) > div > section.bl-section.pv-24.u-border--bottom > div > div > h1"));
    String Page = page.getText();
    System.out.println(Page);
    System.out.println("================TEKS YANG DI AMBIL==================\n"+teks);
//Melakukan Clik ke next page
    WebElement nextPage = driver.findElement(By.className("bl-ghostblock-pagination__next"));
    nextPage.click();
//menunggu reload selama 10 detik 
    try{
        Thread.sleep(1000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
    // Menutup  browser
    driver.quit();
        
           
    }
}