package bookTicket.pageObjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PurchasePage extends PageObject {

    public static final By NAME = By.id("inputName");
    public static final By ADDRESS = By.id("address");
    public static final By CITY = By.id("city");
    public static final By STATE = By.id("state");
    public static final By ZIPCODE = By.id("zipCode");
    public static final By CARD_TYPE = By.id("cardType");
    public static final By CREDIT_CARD_NUMBER = By.id("creditCardNumber");
    public static final By MONTH = By.id("creditCardMonth");
    public static final By YEAR = By.id("creditCardYear");
    public static final By NAMEONCARD = By.id("nameOnCard");

    public static final By PURCHASE = By.cssSelector("input.btn.btn-primary");


    public void personDetails(String name, String address, String city,
                               String state, String zipcode){
        assertThat("Title", getDriver().getTitle().equals("BlazeDemo Purchase"));
        find(NAME).sendKeys(name);
        find(ADDRESS).sendKeys(address);
        find(CITY).sendKeys(city);
        find(STATE).sendKeys(state);
        find(ZIPCODE).sendKeys(zipcode);
    }


    public void cardDetails(String cardType, String cardNumber, String month,
                               String year, String nameOnCard){

        Select card_type = new Select(find(CARD_TYPE));
        card_type.selectByVisibleText(cardType);
        assertThat(card_type.getFirstSelectedOption().getText(), is(cardType));
        find(CREDIT_CARD_NUMBER).sendKeys(cardNumber);
        find(MONTH).sendKeys(month);
        find(YEAR).sendKeys(year);
        find(NAMEONCARD).sendKeys(nameOnCard);
    }

    public void purchaseTicket(){
        find(PURCHASE).click();
    }


}
