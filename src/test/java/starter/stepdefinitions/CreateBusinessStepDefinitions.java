package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import starter.navigation.NavigateTo;
import starter.ui.business.CheckBusiness;
import starter.ui.business.DoBusiness;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

public class CreateBusinessStepDefinitions {

    private String nameBusiness;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^he enters he creates the business (.*)")
    public void he_enters_he_creates_the_business(String nameBusiness) {
        //Business Creation
        this.nameBusiness = nameBusiness;
        theActorInTheSpotlight().attemptsTo(DoBusiness.withName(nameBusiness));
    }
    @When("he validates the creation of the business and goes to the meeting module")
    public void he_validates_the_creation_of_the_business_and_goes_to_the_meeting_module() {
        //Validate business creation
        theActorInTheSpotlight().should(
            seeThat("The name of the business ",CheckBusiness.isCreated(nameBusiness), Matchers.equalTo(nameBusiness))
        );
        //Navigate to Meeting Section
        theActorInTheSpotlight().attemptsTo( NavigateTo.theMeetingSection() );
    }
}
