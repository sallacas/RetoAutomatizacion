package starter.ui.meetings;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

public class CheckMeeting implements Question<String> {

    private String nameBusiness;
    private String typeMeeting;

    public CheckMeeting(String nameBusiness, String typeMeeting) {
        this.nameBusiness = nameBusiness;
        this.typeMeeting = typeMeeting;
    }

    public static Question<String> isCreated(String nameBusiness,String typeMeeting) {
        return new CheckMeeting(nameBusiness,typeMeeting);
    }
    public By meetingCreated(String nBusiness){
        By path = By.xpath("//div[@class='slick-cell l1 r1']/a[text()='"+typeMeeting+" "+nBusiness+"']");
        return path;
    }
    @Override
    public String answeredBy(Actor actor) {
        By target = meetingCreated(nameBusiness);
        actor.attemptsTo(
                Click.on(MeetingOverview.REFRESH_BUTTON)
        );
        String result = BrowseTheWeb.as(actor).find(target).getText();
        return result;
    }
}
