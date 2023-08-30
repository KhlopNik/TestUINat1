package com.stepup;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SelenidePagePobedaInfo {
    By titleText =  By.xpath("//title");
    By logo = By.cssSelector("div.dp-mm9gp7-bottomContent.dp-3mDCvn-bottomContent-ref > div > a > img");
    By infoLink = By.xpath("//a[@href='/information']");
    By titleFlightPreparation = By.xpath("//*[text()='Подготовка к полёту']");
    By titleHelpfulInformation = By.xpath("//*[text()='Полезная информация']");
    By titleAboutCompany = By.xpath("//*[text()='О компании']");

    public SelenidePagePobedaInfo(){
    }
    public void openPage(){
        Selenide.open("https://pobeda.aero/");
    }

    //Получаем заголовок страницы
    public String getTitle(){
        return $(titleText).getAttribute("innerText");
    }
    public boolean checkLogo(){
        return $(logo).isDisplayed();
    }
    public void infoLink(){
        $(infoLink).hover();
    }
    public String getTitleFlightPreparation(){
        return $(titleFlightPreparation).getText();
    }
    public String getTitleHelpfulInformation(){
        return $(titleHelpfulInformation).getText();
    }
    public String getTitleAboutCompany(){
        return $(titleAboutCompany).getText();
    }
}