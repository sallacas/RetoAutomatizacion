package starter.ui.meetings;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.Keys;


public class DoMeeting implements Task {

    private String nameBusiness;

    public DoMeeting(String nameBusiness) {
        this.nameBusiness = nameBusiness;
    }

    public static Performable forA(String nameB){
        return Tasks.instrumented(DoMeeting.class,nameB);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MeetingOverview.NEW_MEETING_BUTTON),
                Enter.theValue("Daily Meeting "+nameBusiness).into(MeetingOverview.MEETING_NAME),//NAME
                Click.on(MeetingOverview.MEETING_TYPE_SELECT).then(Task.where("Add Type Meeting",
                        Enter.theValue("Team Weekly").into(MeetingOverview.DROPDOWN_BOX).thenHit(Keys.ENTER))
                ),
                Enter.theValue("00054").into(MeetingOverview.MEETING_NUMBER)//NUMBER
        );
        actor.attemptsTo(
                Clear.field(MeetingOverview.START_DATE).then(Task.where("Enter Start Date",
                        Enter.theValue("03/29/2022").into(MeetingOverview.START_DATE))
                ),
                SelectFromOptions.byValue("08:30").from(MeetingOverview.TIME_START_DATE),//SET TIMES
                SelectFromOptions.byValue("09:00").from(MeetingOverview.TIME_END_DATE),
                Clear.field(MeetingOverview.END_DATE).then(Task.where("Enter End Date",
                        Enter.theValue("03/29/2022").into(MeetingOverview.END_DATE))
                )
        );
        actor.attemptsTo(
                Click.on(MeetingOverview.LOCATION).then(Task.where("Add location",
                        Enter.theValue("HQ-02").into(MeetingOverview.DROPDOWN_BOX).thenHit(Keys.ENTER))
                ),
                Click.on(MeetingOverview.UNIT).then(Task.where("Add Unit",
                        Enter.theValue(nameBusiness).into(MeetingOverview.DROPDOWN_BOX).thenHit(Keys.ENTER))
                ),
                Click.on(MeetingOverview.ORGANIZED_BY).then(Task.where("Add Host",
                        Enter.theValue("John Brooks").into(MeetingOverview.DROPDOWN_BOX).thenHit(Keys.ENTER))
                ),
                Click.on(MeetingOverview.REPORTER).then(Task.where("Add Reporter",
                        Enter.theValue("Kyle Rivera").into(MeetingOverview.DROPDOWN_BOX).thenHit(Keys.ENTER))
                )
        );
    }
}
