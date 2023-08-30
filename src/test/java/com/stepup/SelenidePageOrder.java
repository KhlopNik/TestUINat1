package com.stepup;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class SelenidePageOrder {
    By bookingManagementPoint = By.cssSelector("div.dp-1fbu4lw-root > div:nth-child(1) > div:nth-child(3) > a");
    By fullScroll = By.cssSelector("#__next > div > footer > div.dp-1pr8ed5-root > div > div.dp-y6ivb6-root > div.dp-shuw2i-root");
    By fieldOrderOrTicketNumber = By.cssSelector("#__next > div.dp-lw1vya-root > main > div > div:nth-child(3) > div.dp-sl49gu-root > form > div > div:nth-child(2) > div.dp-1vwaa72-root > div > input");
    By fieldLastNameOfTheClient = By.cssSelector("div:nth-child(1) > div.dp-1vwaa72-root > div > input");
    By fieldSearchButton = By.cssSelector("#__next > div > main > div > div:nth-child(3) > div.dp-sl49gu-root > form > div > div.dp-kpzb49-root > button");
    By errorMessage = By.cssSelector(".message_error");
    public SelenidePageOrder(){
    }
    @Step("Шаг номер 1")
    public void scrollToElement(By by){
        $(by).scrollTo();
    }
    public void clickBookingManagementPoint(){
        $(bookingManagementPoint).click();
    }
    public Boolean checkFindElement(By by){
        return $(by).isDisplayed();
    }
    public void clickElement(By by){
        $(by).click();
    }
    public void enteringTextIntoAnElement(By by, String str){
        $(by).click();
        $(by).sendKeys(str);
    }
    public String getTextElement(By el){
        return $(el).getText();
    }
    public String getTextErrorMessage(){
        return $(errorMessage).getAttribute("textContent");
    }
    public void switchToOpenTab(){
        switchTo().window(1);
    }
}
