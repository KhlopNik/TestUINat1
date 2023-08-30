package com.stepup;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SelenideTicketSearchPage {
    By blockTicketSearch = By.cssSelector("div.dp-171h76h-root-container > div");
    By fieldFrom = By.cssSelector("div.dp-1c1eqrl-root > div > div:nth-child(1) > div > div > input");
    By fieldThere = By.cssSelector("div.dp-1c1eqrl-root > div > div:nth-child(4) > div > div > input");
    By dateOfDeparture = By.cssSelector("div.dp-1pr8ed5-root > div > div:nth-child(1) > div > input");
    By dateOfDepartureFromThere = By.cssSelector("div.dp-1pr8ed5-root > div > div:nth-child(1) > div > input");
    By enterFrom = By.cssSelector("button:nth-child(1) > div > div.dp-vgaeps-root-suggestionName");
    By enterThere = By.cssSelector("div.dp-vgaeps-root-suggestionName");
    By searchButton = By.cssSelector("div.dp-1v9fi4c-root > button");
    By ErrorBorderFlag = By.cssSelector("[data-errored='true'].dp-1uwjy55-root");
    public SelenideTicketSearchPage(){
    }
    public boolean checkBlockTicketSearch(){
        return $(blockTicketSearch).isDisplayed();
    }
    public Boolean checkFindElementFieldFrom(){
        return $(fieldFrom).isDisplayed();
    }
    public Boolean checkFindElementFieldThere(){
        return $(fieldThere).isDisplayed();
    }
    public Boolean checkFindElementDateOfDeparture(){
        return $(dateOfDeparture).isDisplayed();
    }
    public Boolean checkFindElementDateOfDepartureFromThere(){
        return $(dateOfDepartureFromThere).isDisplayed();
    }

    public void clickFindElementFieldFrom(){
        $(fieldFrom).click();
    }
    public void clickFindElementFieldThere(){
        $(fieldThere).click();
    }
    public void clickFindElementDateOfDeparture(){
        $(dateOfDeparture).click();
    }

    public void inputFieldFrom(String str){
        $(fieldFrom).sendKeys(str);
        $(enterFrom).click();
    }
    public void inputtFieldThere(String str){
        $(fieldThere).sendKeys(str);
        $(enterThere).click();
    }
    public void clickSearchButton(){
        $(searchButton).click();
    }

    public Boolean getCheckErrorBorderDateOfDeparture(){
        return $(ErrorBorderFlag).isDisplayed();
    }
}
