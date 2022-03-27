package starter.ui.meetings;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Save implements Task {
    public static Performable theMeeting() {
        return Tasks.instrumented(Save.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MeetingOverview.SAVE_BUTTON)
        );
    }
}
