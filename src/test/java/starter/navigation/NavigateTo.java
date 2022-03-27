package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import starter.ui.dashboard.DashboardOverview;

public class NavigateTo  {

    public static Performable theStartSharpPage() {
        return Task.where("{0} opens the StartSharp home page",
                Open.browserOn().the(StartSharpHomePage.class)
        );
    }
    public static Performable theBusinessSection() {
        return Task.where("{0} open the business section",
                Click.on(DashboardOverview.ORG_OPTION),
                Click.on(DashboardOverview.BUSINESS_UNIT)
        );
    }
    public static Performable theMeetingSection() {
        return Task.where("{0} open the meeting section",
                Click.on(DashboardOverview.MET_OPTION),
                Click.on(DashboardOverview.MEETINGS)
        );
    }

}