package starter.ui.meetings;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class Add implements Task {
    public static Performable theAttendees() {
        return Tasks.instrumented(Add.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MeetingOverview.ATTENDEES).then(Task.where("Add Attendee",
                        Enter.theValue("Allison").into(MeetingOverview.DROPDOWN_BOX).thenHit(Keys.ENTER)
                )),
                Click.on(MeetingOverview.ATTENDEES).then(Task.where("Add Attendee",
                        Enter.theValue("Brian").into(MeetingOverview.DROPDOWN_BOX).thenHit(Keys.ENTER)
                )),
                Click.on(MeetingOverview.ATTENDEES).then(Task.where("Add Attendee",
                        Enter.theValue("Emily").into(MeetingOverview.DROPDOWN_BOX).thenHit(Keys.ENTER)
                )),
                Click.on(MeetingOverview.ATTENDEES).then(Task.where("Add Attendee",
                        Enter.theValue("Joseph").into(MeetingOverview.DROPDOWN_BOX).thenHit(Keys.ENTER)
                ))
        );

    }
}
