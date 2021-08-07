package bookTicket.steps;

import bookTicket.pageObjects.FlightsDetailsPage;
import bookTicket.pageObjects.PurchasePage;
import net.thucydides.core.annotations.Step;

public class PurchaseSteps {

    private String actor;

    PurchasePage purchasePage;

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
