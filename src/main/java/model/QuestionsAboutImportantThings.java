package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuestionsAboutImportantThings {

    private final WebDriver driver;
    private By locQuestion;
    private By locAnswer;

    public QuestionsAboutImportantThings(WebDriver driver) {
        this.driver = driver;
    }

    //кликнуть по элементу списка Вопросы о важном
    public String clickElementDropDownList(By locQuestion, By locAnswer) {
        driver.findElement(locQuestion).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locAnswer));
        return driver.findElement(locAnswer).getText();

    }
}
