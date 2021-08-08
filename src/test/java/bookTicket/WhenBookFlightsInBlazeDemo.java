package bookTicket;

import bookTicket.steps.ConfirmationSteps;
import bookTicket.steps.FlightDetailsSteps;
import bookTicket.steps.PurchaseSteps;
import bookTicket.steps.WelcomeSteps;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenBookFlightsInBlazeDemo {

    @Steps
    WelcomeSteps john;

    @Steps
    FlightDetailsSteps james;

    @Steps
    PurchaseSteps joe;

    @Steps
    ConfirmationSteps jack;

    @Managed
    WebDriver driver;

    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    //passenger Details
    String name = EnvironmentSpecificConfiguration.from(variables).getProperty("passenger.manager.name");
    String address  = EnvironmentSpecificConfiguration.from(variables).getProperty("passenger.manager.address");
    String city = EnvironmentSpecificConfiguration.from(variables).getProperty("passenger.manager.city");
    String state = EnvironmentSpecificConfiguration.from(variables).getProperty("passenger.manager.state");
    String zipcode = EnvironmentSpecificConfiguration.from(variables).getProperty("passenger.manager.zipcode");

    //card Details
    String cardType = EnvironmentSpecificConfiguration.from(variables).getProperty("passenger.manager.cardType");
    String cardNumber = EnvironmentSpecificConfiguration.from(variables).getProperty("passenger.manager.creditCard");
    String month = EnvironmentSpecificConfiguration.from(variables).getProperty("passenger.manager.month");
    String year = EnvironmentSpecificConfiguration.from(variables).getProperty("passenger.manager.year");


    @Test
    public void selectFlights(){
        john.is_on_WelcomePage();
        john.selectCities("Boston", "Rome");
        james.view_FlightFromOptions("Boston", "Rome");
    }

    @Test
    public void purchaseTicket(){
        john.is_on_WelcomePage();
        john.selectCities("Boston", "Rome");
        james.view_FlightFromOptions("Boston", "Rome");
        joe.select_and_verify_flight();
        joe.enter_PassengerDetails(name, address, city, state, zipcode);
        joe.enter_CardDetails(cardType, cardNumber, month, year, name);
        joe.purchaseFlightTicket();
        jack.confirm_ID();
    }

    @Test
    public void purchaseTicketOnly(){
        joe.is_on_PurchasePage();
        joe.enter_PassengerDetails(name, address, city, state, zipcode);
        joe.enter_CardDetails(cardType, cardNumber, month, year, name);
        joe.purchaseFlightTicket();
        jack.confirm_ID();
    }


}
