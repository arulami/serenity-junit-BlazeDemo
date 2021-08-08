package bookTicket.steps;

import bookTicket.pageObjects.WelcomePage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WelcomeSteps {

    private String actor;

    WelcomePage welcomePage;

    @Step("#actor on WelcomePage")
    public void is_on_WelcomePage(){
        welcomePage.open();
    }

    @Step("#actor select departure and destination cities")
    public void selectCities(String from, String to){
        welcomePage.selectDeparture(from);
        assertThat(welcomePage.selectDeparture(from), is(from));
        welcomePage.selectDestination(to);
        assertThat(welcomePage.selectDestination(to), is(to));
        welcomePage.findFlight();
    }

}
