package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import static utils.Constants.getData;

public class OpenUrl implements Task{

    static String strReferenceUrl;

    public OpenUrl(String strReferenceUrl)
    {
        OpenUrl.strReferenceUrl = strReferenceUrl;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.url(getData(strReferenceUrl)));
    }

    public static OpenUrl doTask(String strReferenceUrl)
    {
        return Tasks.instrumented(OpenUrl.class, strReferenceUrl);
    }
    
}
