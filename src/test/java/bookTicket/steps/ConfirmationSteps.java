package bookTicket.steps;

import bookTicket.pageObjects.ConfirmationPage;
import bookTicket.pageObjects.FlightsDetailsPage;
import net.thucydides.core.annotations.Step;

public class ConfirmationSteps {

    private String actor;

    ConfirmationPage confirmationPage;

    @Step("#actor confirms Booking ID")
    public void confirm_ID(){
        confirmationPage.confirmTicketID();
    }

}
