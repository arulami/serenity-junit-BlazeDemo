package bookTicket.steps;

import bookTicket.pageObjects.FlightsDetailsPage;
import bookTicket.pageObjects.WelcomePage;
import net.thucydides.core.annotations.Step;

public class FlightDetailsSteps {

    private String actor;

    FlightsDetailsPage flightsDetailsPage;

    @Step("#actor is on FlightOptions Page")
    public void select_FlightFromOptions(){
        flightsDetailsPage.selectFlightFromOptions();
    }

    @Step("#actor select cheap flight")
    public void select_cheap_flight(){
        //get text from all td to determine cheap
    }
}
