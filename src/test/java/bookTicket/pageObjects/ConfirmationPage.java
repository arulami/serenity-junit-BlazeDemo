package bookTicket.pageObjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ConfirmationPage extends PageObject {

    public static final By THANK_YOU = By.tagName("h1");
    public static final By CONFIRMATION_ID = By.xpath("/html/body/div[2]/div/table/tbody/tr[1]/td[2]");

    public String confirmTicketID() {
        return find(CONFIRMATION_ID).getText();
    }

    public String verify_ThankYou() {
        return find(THANK_YOU).getText();

    }


}