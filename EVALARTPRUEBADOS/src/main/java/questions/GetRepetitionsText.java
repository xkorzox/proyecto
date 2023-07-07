package questions;
import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import ui.EvalarAutomationTestPage;
public class GetRepetitionsText implements Question <String> {
    
    public static String strRepetitionsQuantityText;
    Target REPETITIONS_QUANTITY_TEXT;
    

    public GetRepetitionsText(Target REPETITIONS_QUANTITY_TEXT) {
      this.REPETITIONS_QUANTITY_TEXT=REPETITIONS_QUANTITY_TEXT;
	}

    @Override
    public String answeredBy(Actor actor) {
      
      strRepetitionsQuantityText =REPETITIONS_QUANTITY_TEXT
      .resolveFor(actor).getText();
      
      
        return "";
    }


    public static GetRepetitionsText make() {
		return new GetRepetitionsText(
      EvalarAutomationTestPage.REPETITIONS_QUANTITY_TEXT);
	}
}
