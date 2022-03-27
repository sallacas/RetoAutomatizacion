package starter.ui.business;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;

public class CheckBusiness implements Question<String> {

    private String nameBusiness;

    public CheckBusiness(String nameBusiness) {
        this.nameBusiness = nameBusiness;
    }

    public static Question<String> isCreated(String nameBusiness){
        return new CheckBusiness(nameBusiness);
    }
    public By businnesCreated (String name){
        By path = By.xpath("//div[@class='slick-cell l1 r1']/a[text()='"+name+"']");
        return path;
    }
    @Override
    public String answeredBy(Actor actor) {
        By target = businnesCreated(nameBusiness);
        actor.attemptsTo(
                Scroll.to(BusinessOverview.DOWN),
                Click.on(BusinessOverview.REFRESH_BUTTON)
        );
        String result = BrowseTheWeb.as(actor).find(target).getText();
        return result;
    }
}
