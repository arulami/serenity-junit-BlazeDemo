package bookTicket.pageObjects;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DefaultUrl("https://blazedemo.com")
public class WelcomePage extends PageObject {
    public static final By DEPARTURE_CITY_COMBO = By.name("fromPort");
    public static final By DESTINATION_CITY_COMBO = By.name("toPort");
    public static final By FIND_FLIGHTS = By.cssSelector("input.btn.btn-primary");


    public void selectCities(String from, String to){
        Select departure_cityList = new Select(find(DEPARTURE_CITY_COMBO));
        departure_cityList.selectByVisibleText(from);
        assertThat(departure_cityList.getFirstSelectedOption().getText(), is(from));

        Select destination_cityList = new Select(find(DESTINATION_CITY_COMBO));
        destination_cityList.selectByVisibleText(to);
        assertThat(destination_cityList.getFirstSelectedOption().getText(), is(to));

        find(FIND_FLIGHTS).click();
    }
}
