package bookTicket.steps;

import bookTicket.pageObjects.FlightsDetailsPage;
import bookTicket.pageObjects.WelcomePage;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FlightDetailsSteps {

    private String actor;

    FlightsDetailsPage flightsDetailsPage;

    @Step("#actor is on FlightOptions Page")
    public void view_FlightFromOptions(String from, String to){
        assertThat(flightsDetailsPage.reserveHeader(), containsString(from));
        assertThat(flightsDetailsPage.reserveHeader(), containsString(to));
    }

    @Step("#actor select cheap flight")
    public void select_cheap_flight(){
        //get text from all td to determine cheap price
        flightsDetailsPage.selectCheapFlights();
    }
}
