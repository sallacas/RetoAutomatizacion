package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import starter.ui.login.DoLogin;
import starter.ui.login.LoginResult;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class LoginStepDefinitions {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) navigate to the page")
    public void navigate_to_the_page(String name) {
        //Open StartSharp Home Page
        theActorCalled(name).wasAbleTo(NavigateTo.theStartSharpPage());
    }

    @When("he sends their valid credentials")
    public void he_sends_their_valid_credentials() {
        //Login in the application
        theActorInTheSpotlight().attemptsTo(DoLogin.withCredentials("admin","serenity"));
    }

    @And("he should enter the dashboard and go to business section")
    public void he_should_enter_the_dashboard_and_go_to_business_section() {
        //Validate login
        theActorInTheSpotlight().should(
                seeThat("The dashboard of the page",LoginResult.value(), Matchers.equalTo("Dashboard"))
        );
        //Navigate to Business Section
        theActorInTheSpotlight().attemptsTo(NavigateTo.theBusinessSection());
    }
}
