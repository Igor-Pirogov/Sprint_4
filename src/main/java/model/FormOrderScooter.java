package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormOrderScooter {

    private final WebDriver driver;
    private By locForFieldFormOrder;
    private String textForFieldFormOrder;

    public FormOrderScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Ищем по локатору поле на форме Заказа
    public void fillFieldFormOrder(By locForFieldFormOrder, String textForFieldFormOrder) {
        WebElement element = driver.findElement(locForFieldFormOrder);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.sendKeys(textForFieldFormOrder);
    }
    //кликаем по полю в форме заказа (ищем поле по локатору)
    public void clickFieldFormOrder(By locForFieldFormOrder) {
        WebElement element = driver.findElement(locForFieldFormOrder);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    //public void clickOrderButtonNext() {
    //    WebElement element = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[3]/button"));
    //    new WebDriverWait(driver, Duration.ofSeconds(30))
    //            .until(ExpectedConditions.elementToBeClickable(element));
    //    element.click();
    //}



}
