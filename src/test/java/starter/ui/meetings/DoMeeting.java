package starter.ui.meetings;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actions.type.TypeValue;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.Keys;

public class DoMeeting implements Task {

    private String nameBusiness;
    private String typeMeeting;
    private String startD;
    private String startH;
    private String endH;
    private String location;

    public DoMeeting(String nameBusiness, String typeMeeting, String date, String startH, String endH, String location) {
        this.nameBusiness = nameBusiness;
        this.typeMeeting = typeMeeting;
        this.startD = date;
        this.startH = startH;
        this.endH = endH;
        this.location = location;
    }

    public static Performable forA(String nameBusiness, String typeMeeting, String date, String startH, String endH, String location){
        return Tasks.instrumented(DoMeeting.class,nameBusiness,typeMeeting,date,startH,endH,location);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MeetingOverview.NEW_MEETING_BUTTON),
                Enter.theValue(typeMeeting+" "+nameBusiness).into(MeetingOverview.MEETING_NAME),//NAME
                Click.on(MeetingOverview.MEETING_TYPE_SELECT).then(Task.where("Add Type Meeting",
                        Enter.theValue(typeMeeting).into(MeetingOverview.DROPDOWN_BOX).thenHit(Keys.ENTER))
                ),
                Enter.theValue("00945").into(MeetingOverview.MEETING_NUMBER)//NUMBER
        );
        actor.attemptsTo(
                Clear.field(MeetingOverview.START_DATE),
                Enter.keyValues("03/30/2022").into(MeetingOverview.START_DATE),
                SelectFromOptions.byValue(startH).from(MeetingOverview.TIME_START_DATE),//SET TIMES
                SelectFromOptions.byValue(endH).from(MeetingOverview.TIME_END_DATE),
                Clear.field(MeetingOverview.END_DATE).then(Task.where("Enter End Date",
                        Enter.theValue("03/30/2022").into(MeetingOverview.END_DATE))
                )
        );
        System.out.println(startD);
        actor.attemptsTo(
                Click.on(MeetingOverview.LOCATION).then(Task.where("Add location",
                        Enter.theValue(location).into(MeetingOverview.DROPDOWN_BOX).thenHit(Keys.ENTER))
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
