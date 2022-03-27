package starter.ui.business;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

public class DoBusiness implements Task {

    private String nameBusiness;

    public DoBusiness(String nameBusiness) {
        this.nameBusiness = nameBusiness;
    }

    public static Performable withName(String nameBusiness){
        return Tasks.instrumented(DoBusiness.class,nameBusiness);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BusinessOverview.NEW_BUTTON), //Select name
                Enter.theValue(nameBusiness).into(BusinessOverview.NAME_BOX),
                Click.on(BusinessOverview.DROPDOWN_1), //Select category
                Enter.theValue("Technology").into(BusinessOverview.PARENT_BOX).thenHit(Keys.ARROW_DOWN),
                Hit.the(Keys.ARROW_DOWN).into(BusinessOverview.PARENT_BOX),
                Hit.the(Keys.ENTER).into(BusinessOverview.PARENT_BOX),
                Click.on(BusinessOverview.SAVE_BUTTON)
        );
    }
}
