package bookTicket.pageObjects;

import io.cucumber.java.bs.A;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class FlightsDetailsPage extends PageObject {

    public static final By FLIGHT_OPTIONS = By.tagName("tr");

    public void selectFlightFromOptions(){
        assertThat(findAll(FLIGHT_OPTIONS).size(), is(greaterThan(0)));
        int flightsList = findAll(FLIGHT_OPTIONS).size();
        //iterate
        List<String> flightPrice = new ArrayList<>();
        for(int i = 1; i < flightsList; i++){
            flightPrice.add(find(By.xpath("/html/body/div[2]/table/tbody/tr["+i+"]/td[6]")).getText()
                    .replaceAll("[$,]", ""));
        }

        System.out.println("Check Price" + flightPrice);
        Collections.sort(flightPrice);

        //click
        for(int i = 1; i <= flightsList; i++){
            if (find(By.xpath("/html/body/div[2]/table/tbody/tr["+i+"]/td[6]")).getText().contains(flightPrice.get(0))){
                //click button
                find(By.xpath("/html/body/div[2]/table/tbody/tr["+i+"]/td[1]/input")).click();
                break;
            }
        }

    }

}
