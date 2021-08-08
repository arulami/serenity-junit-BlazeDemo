package bookTicket.pageObjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class FlightsDetailsPage extends PageObject {

    public static final By FLIGHT_OPTIONS = By.tagName("tr");
    public static final By RESERVE_HEADING = By.tagName("h3");
    public static final By DEPARTS = By.xpath("/html/body/div[2]/table/thead/tr/th[4]");
    public static final By ARRIVES = By.xpath(" /html/body/div[2]/table/thead/tr/th[5]");

    public String selectCheapFlights(){
        String flight_no = "";
        assertThat(findAll(FLIGHT_OPTIONS).size(), is(greaterThan(0)));
        int flightsList = findAll(FLIGHT_OPTIONS).size();
        //iterate
        List<String> flightPrice = new ArrayList<>();
        for(int i = 1; i < flightsList; i++){
            flightPrice.add(find(By.xpath("/html/body/div[2]/table/tbody/tr["+i+"]/td[6]")).getText()
                    .replaceAll("[$,]", ""));
        }
        //sort to get cheap price
        Collections.sort(flightPrice);

        //click
        for(int i = 1; i <= flightsList; i++){
            if (find(By.xpath("/html/body/div[2]/table/tbody/tr["+i+"]/td[6]")).getText().contains(flightPrice.get(0))){
                flight_no = find(By.xpath("/html/body/div[2]/table/tbody/tr["+i+"]/td[2]")).getText();
                //click button
                find(By.xpath("/html/body/div[2]/table/tbody/tr["+i+"]/td[1]/input")).click();
                break;
            }
        }
        return flight_no;
    }

    public String reserveHeader(){
        return find(RESERVE_HEADING).getText();
    }

    public List<String> departsAndArrives(){
        List<String> depart_arrives = new ArrayList<>();
        depart_arrives.add(find(DEPARTS).getText());
        depart_arrives.add(find(ARRIVES).getText());
        return depart_arrives;
    }

}
