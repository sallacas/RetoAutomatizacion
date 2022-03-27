package starter.ui.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoLogin implements Task {

    private final String username;
    private final String password;

    public DoLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Performable withCredentials(String username,String password){
        return instrumented(DoLogin.class,username,password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(LoginForm.USERNAME_BOX), // Clear inputs
                Clear.field(LoginForm.PASSWORD_BOX),
                Enter.theValue(username).into(LoginForm.USERNAME_BOX),// Enter values
                Enter.theValue(password).into(LoginForm.PASSWORD_BOX),
                Click.on(LoginForm.LOGIN_BUTTON)// Login
        );
    }
}
