package starter.ui.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import starter.ui.dashboard.DashboardOverview;

public class LoginResult implements Question<String> {

    public static Question<String> value(){
        return new LoginResult();
    }

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(DashboardOverview.DASHBOARD_TITLE).getText();
    }
}
