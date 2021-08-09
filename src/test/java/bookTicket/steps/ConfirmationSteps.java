package bookTicket.steps;

import bookTicket.pageObjects.ConfirmationPage;
import bookTicket.pageObjects.FlightsDetailsPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ConfirmationSteps {

    private String actor;

    ConfirmationPage confirmationPage;

    @Step("#actor confirms Booking ID")
    public void confirm_ID(){
        assertThat(confirmationPage.confirmTicketID(), not(emptyString()));
    }


    @Step("#actor verify Thank you message")
    public void see_ThankYou(){
        assertThat(confirmationPage.verify_ThankYou(), containsString("Thank you"));
    }


}
