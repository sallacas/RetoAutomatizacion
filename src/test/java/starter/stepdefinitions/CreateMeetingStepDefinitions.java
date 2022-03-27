package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import starter.ui.meetings.*;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateMeetingStepDefinitions {

    private String nameBusiness;
    private String typeMeeting;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^he creates a new meeting for the business (.*) with data Type (.*) Date(.*) Times (.*) (.*) Location (.*)")
    public void he_creates_a_new_meeting_for_the_business
    (String nBusiness, String type,String date,String startH,String endH,String location) {
        this.nameBusiness = nBusiness;
        this.typeMeeting = type;
        theActorInTheSpotlight().attemptsTo(
                DoMeeting.forA(nameBusiness,type,date,startH,endH,location),
                Add.theAttendees(),
                Save.theMeeting()
        );
    }
    @Then("he finds his meeting created")
    public void he_finds_his_meeting_created() {
        String nameMeeting = typeMeeting+" "+nameBusiness;
        theActorInTheSpotlight().should(
                seeThat("Meeting created", CheckMeeting.isCreated(nameBusiness, typeMeeting), Matchers.equalTo(nameMeeting))
        );
    }
}
