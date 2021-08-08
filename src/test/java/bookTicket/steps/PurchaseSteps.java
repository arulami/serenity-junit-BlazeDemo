package bookTicket.steps;

import bookTicket.pageObjects.FlightsDetailsPage;
import bookTicket.pageObjects.PurchasePage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class PurchaseSteps {

    private String actor;

    FlightsDetailsPage flightsDetailsPage;
    PurchasePage purchasePage;

    @Step("#actor on PurchasePage")
    public void is_on_PurchasePage(){
        purchasePage.open();
    }

    @Step("#actor verifies selected cheap flight details")
    public void select_and_verify_flight(){
        String fight_number = flightsDetailsPage.selectCheapFlights();
        assertThat(purchasePage.getFlightNumber(), containsString(fight_number));
    }


    @Step("#actor enters passenger details")
    public void enter_PassengerDetails(String name, String address, String city,
                                         String state, String zipcode){
        purchasePage.personDetails(name, address, city, state,zipcode);
    }

    @Step("#actor enters credit card details")
    public void enter_CardDetails(String cardType, String cardNumber, String month,
                                  String year, String nameOnCard){
        purchasePage.cardDetails(cardType, cardNumber, month, year,nameOnCard);
    }

    @Step("#actor purchase ticket")
    public void purchaseFlightTicket(){
        purchasePage.purchaseTicket();
    }
}
