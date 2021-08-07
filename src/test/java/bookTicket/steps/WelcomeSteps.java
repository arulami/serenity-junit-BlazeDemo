package bookTicket.steps;

import bookTicket.pageObjects.WelcomePage;
import net.thucydides.core.annotations.Step;

public class WelcomeSteps {

    private String actor;

    WelcomePage welcomePage;

    @Step("#actor on WelcomePage")
    public void is_on_WelcomePage(){
        welcomePage.open();
    }

    @Step("#actor select departure and destination cities")
    public void selectCities(String from, String to){
        welcomePage.selectCities(from, to);
    }

}
