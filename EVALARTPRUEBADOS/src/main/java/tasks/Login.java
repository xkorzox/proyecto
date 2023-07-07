package tasks;

import java.util.Map;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import ui.EvalarAutomationLoginPage;

public class Login implements Task{

    Map<String, String> mapUserInfo;
    Target USUARIO_TEXT_FIELD ;
    Target PASSWORD_TEXT_FIELD;
    Target ENVIAR_BUTTON;

    public Login(DataTable tableAccomationInfo, Target USUARIO_TEXT_FIELD,
                Target PASSWORD_TEXT_FIELD, Target ENVIAR_BUTTON ) {
        mapUserInfo = tableAccomationInfo.asMap(String.class, String.class);
        this.USUARIO_TEXT_FIELD = USUARIO_TEXT_FIELD;
        this.PASSWORD_TEXT_FIELD = PASSWORD_TEXT_FIELD;
        this.ENVIAR_BUTTON = ENVIAR_BUTTON;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(mapUserInfo.get("user")).into(USUARIO_TEXT_FIELD),
            Enter.theValue(mapUserInfo.get("password")).into(PASSWORD_TEXT_FIELD),
            Click.on(ENVIAR_BUTTON)
        );

       
    }
    
    public static Login doTasks(DataTable tableAccomationInfo)
    {
        return Tasks.instrumented(Login.class, tableAccomationInfo,
        EvalarAutomationLoginPage.USUARIO_TEXT_FIELD, EvalarAutomationLoginPage.PASSWORD_TEXT_FIELD,
        EvalarAutomationLoginPage.ENVIAR_BUTTON);
    }
}
