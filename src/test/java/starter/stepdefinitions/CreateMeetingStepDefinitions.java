package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.ui.meetings.Add;
import starter.ui.meetings.DoMeeting;
import starter.ui.meetings.Save;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateMeetingStepDefinitions {

    private String nameBusiness;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^he creates a new meeting for the business (.*)")
    public void he_creates_a_new_meeting_for_the_business(String nameBusiness) {
        this.nameBusiness = nameBusiness;
        theActorInTheSpotlight().attemptsTo(
                DoMeeting.forA(nameBusiness),
                Add.theAttendees(),
                Save.theMeeting()
        );
    }
}
